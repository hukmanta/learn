package com.hukman.learn.business.service

import java.util.*

class ProductInMemoryDB {
    companion object {

        private val id: Int
            get() = ++lastId

        fun add(productDto: ProductDto) {
            productDto.id = id
            list.add(productDto)
        }

        fun findAll(): List<ProductDto> {
            return list
        }

        fun findById(id: Int): ProductDto? {
            var item: ProductDto? = null
            list.forEach {
                when (it.id) {
                    id -> {
                        item = it
                        return@forEach
                    }
                }
            }
            return item
        }

        fun remove(id: Int) {
            var toRemove: ProductDto? = null
            list.forEach {
                when (it.id) {
                    id -> {
                        toRemove = it
                        return@forEach
                    }
                }
            }
            if (toRemove != null) list.remove(toRemove!!)
        }

        fun edit(productDto: ProductDto){
            list.forEach {
                when (it.id){
                    productDto.id -> {
                        it.name =productDto.name
                        return@forEach
                    }
                }
            }
        }

        private val list: MutableList<ProductDto> = ArrayList<ProductDto>()
        private var lastId = 0
    }

}

