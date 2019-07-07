package com.chhabravarun.UnifiedSocialProfile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnifiedFeed {

    List<String> twitterFeed;
    List<String> facebookFeed;

}
