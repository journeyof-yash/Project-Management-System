package com.yash.service;

import com.yash.model.PlanType;
import com.yash.model.Subscription;
import com.yash.model.User;

public interface SubscriptionService {

    Subscription createSubscription(User user);

    Subscription getUserSubscription(Long userId)throws Exception;

    Subscription upgradeSubscription(Long userId , PlanType planType);

    boolean isValid(Subscription subscription);

}
