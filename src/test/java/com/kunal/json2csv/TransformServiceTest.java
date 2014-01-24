package com.kunal.json2csv;

import com.kunal.json2csv.TransformService;
import com.kunal.json2csv.bean.TransformServiceBean;
import com.kunal.json2csv.util.ActivatorJAX_RS;
import com.kunal.json2csv.util.Resources;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TransformServiceTest
{
   @Inject
   private TransformService transformservice;

   @Deployment
   public static WebArchive createDeployment()
   {
	   
      return ShrinkWrap.create(WebArchive.class, "transform-service-test.war")
            .addClass(TransformService.class)
            .addClass(TransformServiceBean.class)
            .addClass(ActivatorJAX_RS.class)
            .addClass(Resources.class)
            .addAsLibraries(Maven.resolver().resolve(
            		"org.json:json:20131018"
            		).withTransitivity().asFile())
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void testIsDeployed()
   {
	   String jsonString = 
		   "{\"menu\": {"
		   + "\"id\": \"file\","
		   + "\"value\": \"File\","
		   + "\"popup\": {"
		   + "  \"menuitem\": ["
		   + "    {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},"
		   + "    {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},"
		   + "    {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}"
		   + "  ]"
		   + "}"
		   + "}}";

	   transformservice.convert(jsonString);
      Assert.assertNotNull(transformservice);
   }
}
