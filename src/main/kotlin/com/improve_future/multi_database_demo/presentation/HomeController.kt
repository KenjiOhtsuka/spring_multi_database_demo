package com.improve_future.multi_database_demo.presentation

import com.improve_future.multi_database_demo.domain.first.repository.FirstRepository
import com.improve_future.multi_database_demo.domain.second.repository.SecondRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController(
    private val firstRepository: FirstRepository,
    private val secondRepository: SecondRepository
) {
    @RequestMapping("/{id}")
    @ResponseBody
    fun home(@PathVariable("id") id: Long): String {
        val first = firstRepository.findById(id).get()
        val second = secondRepository.findById(id).get()
        return "${first.name}:${second.name}"
    }
}