package com.klystopad.test;

import com.klystopad.data.BalanceHistoryRepository;
import com.klystopad.data.UserRepository;
import com.klystopad.model.BalanceHistory;
import com.klystopad.model.Member;
import com.klystopad.model.User;
import com.klystopad.service.BalanceHistoryService;
import com.klystopad.service.MemberRegistration;
import com.klystopad.service.UserService;
import com.klystopad.util.Resources;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by Kirill Listopad on 1/9/16.
 */
@RunWith(Arquillian.class)
public class UserServiceTest {

    @Inject
    private UserService userService;

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(User.class, UserRepository.class, UserService.class,
                        BalanceHistoryService.class, BalanceHistoryRepository.class, BalanceHistory.class, Resources.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                        // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml", "test-ds.xml");
    }

    @Test
    public void receiveCash(){

    }


}
