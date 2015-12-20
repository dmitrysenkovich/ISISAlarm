package com.bottles.five.isisalarm.model.face.verify;

public class FaceVerifyRequest {
    private String faceId;
    private String faceListId;
    private int maxNumOfCandidatesReturned;

    public String getFaceId() {
        return faceId;
    }

    public String getFaceListId() {
        return faceListId;
    }

    public int getMaxNumOfCandidatesReturned() {
        return maxNumOfCandidatesReturned;
    }

    public FaceVerifyRequest(String faceId, String faceListId, int maxNumOfCandidatesReturned) {
        this.faceId = faceId;
        this.faceListId = faceListId;
        this.maxNumOfCandidatesReturned = maxNumOfCandidatesReturned;
    }
}
