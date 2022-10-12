package com.thedhobighat

/* Dependencies begin */

data class Serviceable(
    var item: String,
    var quantity: Int
)

/* Dependencies end */

data class LoginCredentials(
    var email: String,
    var password: String
)

data class CartInstance(
    var dry_wash: List<Serviceable>,
    var formal_wash: List<Serviceable>,
    var steam_iron: List<Serviceable>
)