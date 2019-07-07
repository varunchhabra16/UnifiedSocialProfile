package com.chhabravarun.UnifiedSocialProfile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import twitter4j.User;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnifiedProfile {

      CFUser codeForceUser;
      User twitterUser;
      com.restfb.types.User facebookUser;

}
