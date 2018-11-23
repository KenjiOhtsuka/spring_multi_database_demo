package com.improve_future.multi_database_demo.domain.first.repository

import com.improve_future.multi_database_demo.domain.first.model.First
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FirstRepository : JpaRepository<First, Long>