package br.com.dev.osorio.full_curse_spring_boot.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timeStamp, String message, String details) {
}
