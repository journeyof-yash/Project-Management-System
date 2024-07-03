package com.yash.repository;

import com.yash.model.Subscription;
import com.yash.service.SubscriptionService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription , Long> {

    Subscription findByUserId(Long userId);


}
