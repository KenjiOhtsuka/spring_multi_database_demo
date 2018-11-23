package com.improve_future.multi_database_demo.domain.first.model

import javax.persistence.*

@Entity
@Table(name = "users")
class First {
    @Id
    @GeneratedValue
    @Column
    var id: Long? = null

    @Column
    var name: String? = null
}