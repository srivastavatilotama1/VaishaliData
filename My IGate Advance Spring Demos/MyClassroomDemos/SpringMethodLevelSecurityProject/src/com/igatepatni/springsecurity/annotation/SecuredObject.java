package com.igatepatni.springsecurity.annotation;

import org.springframework.security.access.annotation.Secured;

public class SecuredObject 
{
   @Secured( { "ROLE_SECRET_AGENT" })
   public String getSecuredData()
   {
      return "Top-Secret Data";
   }
}
