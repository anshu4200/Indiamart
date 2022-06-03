# Indiamart

###
Swagger : https://documenter.getpostman.com/view/16106019/Uz5Gmaec
### Description
This Project is used for the consumer as well as the seller according to the requirement to get the Product details.

### Endpoints
- To get the list of Product based on searches by Product name : -  http://localhost:8080/customer/name/{name}
- To get the list of Product based on searches by Product type : -  http://localhost:8080/customer/type/{type}
- To get the list of Product based on searches by Product category : -  http://localhost:8080/customer/category/{category}
- To get the list of Product based on searches by Product priceRange : -  http://localhost:8080/customer/priceRange/{price}
- To Add the list of Product (One or more) : -  http://localhost:8080//seller/saved
- To update the product based on id if the seller matches  : -  http://localhost:8080/seller/update
- To delete the product based on id : -  http://localhost:8080/seller/delete/{id}


### Input Parameters

### Output Parameters

### Sample requests
- Request to Add the list of Product
```json
[
	{
	    "name" : "xxdell",
        "type" : "laptop",
		"category" : "Electronic",
		"price" : "20000"
	}
]

```



### Sample Response
