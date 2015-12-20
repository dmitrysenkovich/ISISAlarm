package com.bottles.five.isisalarm.model.face;

/**
 * Created by Evgeny on 20.12.2015.
 */
public class FaceAttributes {
    private Double age;
    private String gender;
    private Double smile;
    private FacialHair facialHair;
    private HeadPose headPose;

    public Double getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Double getSmile() {
        return smile;
    }

    public FacialHair getFacialHair() {
        return facialHair;
    }

    public HeadPose getHeadPose() {
        return headPose;
    }
}
