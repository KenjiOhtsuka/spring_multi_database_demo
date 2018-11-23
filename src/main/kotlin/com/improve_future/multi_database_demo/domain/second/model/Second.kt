package com.improve_future.multi_database_demo.domain.second.model

import javax.persistence.*

@Entity
@Table(name = "users")
class Second {
    @Id
    @GeneratedValue
    @Column
    var id: Long? = null

    @Column
    var name: String? = null
}