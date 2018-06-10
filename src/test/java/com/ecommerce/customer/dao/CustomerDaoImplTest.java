package com.ecommerce.customer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CustomerDaoImplTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void aComponent()
    {
        Assert.assertTrue(context.getBean("applicationContextProvder") != null);
    }

}