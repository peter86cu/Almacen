package com.ayalait.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import com.ayalait.stock.barcode.BarcodeGenerator;
import com.ayalait.stock.barcode.QrCodeGenerator;

import java.awt.image.BufferedImage;

@Configuration
public class AppConfiguration {

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    @Bean
    public BarcodeGenerator getBarcodeGenerator() {
        return new BarcodeGenerator();
    }

    @Bean
    public QrCodeGenerator getQrCodeGenerator() {
        return new QrCodeGenerator();
    }
}