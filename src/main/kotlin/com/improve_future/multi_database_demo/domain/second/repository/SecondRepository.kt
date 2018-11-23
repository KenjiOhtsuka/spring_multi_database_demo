package com.improve_future.multi_database_demo.domain.second.repository

import com.improve_future.multi_database_demo.domain.second.model.Second
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SecondRepository : JpaRepository<Second, Long>