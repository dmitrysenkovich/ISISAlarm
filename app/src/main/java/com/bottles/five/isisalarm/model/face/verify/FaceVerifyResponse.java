package com.bottles.five.isisalarm.model.face.verify;

public class FaceVerifyResponse {

    private String persistedFaceId;
    private Double confidence;

    public String getPersistedFaceId() {
        return persistedFaceId;
    }

    public Double getConfidence() {
        return confidence;
    }
}
