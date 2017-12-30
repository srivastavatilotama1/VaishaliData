package com.igatepatni.springsecurity.annotation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("SpringSecurityTest-context.xml")
public class SpringSecurityTest
{
   @Autowired
   private ApplicationContext context;

   @Test(expected = AuthenticationCredentialsNotFoundException.class)
   public void shouldRejectAccessForUnauthenticatedUser()
   {
      SecuredObject secured = (SecuredObject) context.getBean("securedBean");
      secured.getSecuredData();
   }

   @Test(expected = AccessDeniedException.class)
   public void shouldRejectAccessForUnauthorizedUser()
   {
      authenticateUser("intruder", "password");

      SecuredObject secured = (SecuredObject) context.getBean("securedBean");
      secured.getSecuredData();
   }

   @Test
   public void shouldAllowAccessForAuthorizedUser()
   {
      authenticateUser("training", "secret");

      SecuredObject secured = (SecuredObject) context.getBean("securedBean");
      assertEquals("Top-Secret Data", secured.getSecuredData());
   }

   private void authenticateUser(String username, String password)
   {
      UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(
                        username, password);
      AuthenticationManager authManager = (AuthenticationManager) context
                        .getBean("authenticationManager");
      SecurityContextHolder.getContext().setAuthentication(
                        authManager.authenticate(login));
   }

   @After
   public void tearDown()
   {
      SecurityContextHolder.getContext().setAuthentication(null);
   }
}
