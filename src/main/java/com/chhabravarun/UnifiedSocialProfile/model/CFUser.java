package com.chhabravarun.UnifiedSocialProfile.model;

import lombok.Getter;
import lombok.Setter;

public class CFUser {

    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String country;
    @Getter @Setter
    private Integer rating;
    @Getter @Setter
    private String handle;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private Integer contribution;
    @Getter @Setter
    private String organisation;
    @Getter @Setter
    private Integer rank;

    @Override
    public String toString() {
        return "CFUser{" +
                "lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", handle='" + handle + '\'' +
                ", firstName='" + firstName + '\'' +
                ", contribution=" + contribution +
                ", organisation='" + organisation + '\'' +
                ", rank=" + rank +
                '}';
    }
}