package com.hukman.learn.presentation

import com.hukman.learn.business.service.ProductDto
import com.hukman.learn.business.service.ProductInMemoryDB
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(value = ["/standalone/mock"])
class ProductMockController {

    @RequestMapping(value = ["/create"], method = [RequestMethod.POST])
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    fun create(@RequestBody product: ProductDto): ProductDto{
        ProductInMemoryDB.add(product)
        return product
    }

    @RequestMapping(value = ["/findAll"], method = [RequestMethod.GET])
    @ResponseBody
    fun findAll(): List<ProductDto> {
        return ProductInMemoryDB.findAll()
    }

    @RequestMapping(value = ["/findById/{productId}"], method = [RequestMethod.GET])
    @ResponseBody
    fun findById(@PathVariable("productId") productId :Int): ProductDto?{
        return ProductInMemoryDB.findById(productId)
    }

    @RequestMapping(value = ["/remove/{productId}"], method = [RequestMethod.POST])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun remove(@PathVariable productId: Int){
        ProductInMemoryDB.remove(productId)
    }

    @RequestMapping(value = ["/edit"], method = [RequestMethod.POST])
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @ResponseBody
    fun edit(@RequestBody product: ProductDto): ProductDto{
        ProductInMemoryDB.edit(product)
        return product
    }


}