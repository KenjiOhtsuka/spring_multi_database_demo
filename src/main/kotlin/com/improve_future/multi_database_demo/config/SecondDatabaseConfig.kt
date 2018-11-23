package com.improve_future.multi_database_demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.orm.jpa.JpaTransactionManager
import javax.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "secondEntityManagerFactory",
    transactionManagerRef = "secondTransactionManager",
    basePackages = ["com.improve_future.multi_database_demo.domain.second.repository"]
)
class SecondDatabaseConfig {
    @Bean(name = ["secondDataSource"])
    @ConfigurationProperties(prefix = "second.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean(name = ["secondEntityManagerFactory"])
    fun barEntityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("secondDataSource") dataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages("com.improve_future.multi_database_demo.domain.second.model")
            .persistenceUnit("second")
            .build()
    }

    @Bean(name = ["secondTransactionManager"])
    fun barTransactionManager(
        @Qualifier("secondEntityManagerFactory") barEntityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(barEntityManagerFactory)
    }
}