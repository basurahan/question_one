package link.limecode.question_one

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import link.limecode.question_one.adapter.ProductsAdapter
import link.limecode.question_one.databinding.ActivityMainBinding
import link.limecode.question_one.model.ProductUIModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductsAdapter

    private val lifecycleScope = lifecycle.coroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            productAdapter = ProductsAdapter()
            rvProducts.adapter = productAdapter
        }

        lifecycleScope.launch(Dispatchers.IO) {
            loadData()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private suspend fun loadData() {
        val products = mutableListOf(
            ProductUIModel(
                productName = "Toothpaste",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Toothbrush",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Mouthwash",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Hand Soap",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Candies",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Cotton",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Body Wash",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Floss",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Electric Toothbrush",
                productPrice = 0.0
            ),
            ProductUIModel(
                productName = "Cologne",
                productPrice = 0.0
            )
        )
        var total = 0.0
        for (items in products) {
            val price = Random.nextDouble(from = 100.00, until = 99999.99)
            items.productPrice = price
            total += price
        }
        products.add(
            ProductUIModel(
                productName = TOTAL,
                productPrice = total
            )
        )
        withContext(Dispatchers.Main) {
            productAdapter.submitList(products.toList())
            productAdapter.notifyDataSetChanged()
        }
    }
}

const val TOTAL = "Total"