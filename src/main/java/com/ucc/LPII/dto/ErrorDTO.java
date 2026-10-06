package com.ucc.LPII.dto;

import java.time.LocalDateTime;

public record ErrorDTO(int status, String mensaje, LocalDateTime timestamp) {
}
