package com.economy.application.service;

import com.economy.domain.service.PixService;
import com.economy.dto.input.PixDepositInputDto;
import com.economy.dto.output.PixQrCodeOutputDto;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.resources.payment.Payment;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.ConfigProvider;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class PixServiceImpl implements PixService {

    private String mercadoPagoToken = ConfigProvider.getConfig().getValue("mercadopago.token", String.class);

    @Override
    public PixQrCodeOutputDto
    createQrCode(PixDepositInputDto deposito) {
        try{

            MercadoPagoConfig.setAccessToken(mercadoPagoToken);

            Map<String, String> customHeaders = new HashMap<>();
            customHeaders.put("x-idempotency-key", UUID.randomUUID().toString());

            MPRequestOptions requestOptions = MPRequestOptions.builder()
                    .customHeaders(customHeaders)
                    .build();

            PaymentClient paymentClient = new PaymentClient();
            PaymentCreateRequest paymentCreateRequest = PaymentCreateRequest.builder()
                    .transactionAmount((BigDecimal)deposito.getValor())
                    .description(deposito.getDescricao())
                    .paymentMethodId("pix")
                    .dateOfExpiration(OffsetDateTime.now().plusHours(24))
                    .payer(
                            PaymentPayerRequest.builder()
                                    .email(deposito.getEmail())
                                    .firstName(deposito.getNome())
                                    .identification(IdentificationRequest.builder()
                                            .type("CNPJ")
                                            .number(deposito.getCnpj())
                                            .build())
                                    .build())
                    .build();

            Payment payment = paymentClient.create(paymentCreateRequest, requestOptions);
            PixQrCodeOutputDto pixQrCodeOutputDto = new PixQrCodeOutputDto(
                    deposito.getValor(),
                    deposito.getNome(),
                    payment.getPointOfInteraction().getTransactionData().getQrCode(),
                    payment.getPointOfInteraction().getTransactionData().getQrCodeBase64()
            );

            return pixQrCodeOutputDto;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
