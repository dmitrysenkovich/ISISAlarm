package com.bottles.five.isisalarm.model.face;

public class Face {

    private String faceId;
    private FaceRectangle faceRectangle;
    private FaceLandmarks faceLandmarks;
    private FaceAttributes faceAttributes;

    public String getFaceId() {
        return faceId;
    }

    public FaceRectangle getFaceRectangle() {
        return faceRectangle;
    }

    public FaceLandmarks getFaceLandmarks() {
        return faceLandmarks;
    }

    public FaceAttributes getFaceAttributes() {
        return faceAttributes;
    }
}
