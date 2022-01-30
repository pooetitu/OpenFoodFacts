package com.openfoodfacts.ui.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.openfoodfacts.R
import com.openfoodfacts.Product
import com.openfoodfacts.utils.ProductModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_summary.*

class ProductDetailsSummaryFragment : Fragment() {
    private val model: ProductModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_summary, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val product = model.getSelected().value as Product

        brand.text = product.brand
        title.text = product.name
        barcode.setTextBold(
            getString(
                R.string.barcode,
                product.barCode
            )
        )
        nutriscore.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                product.nutriscore.id
            )
        )
        quantity.setTextBold(
            getString(
                R.string.quantity,
                product.quantity
            )
        )
        soldIn.setTextBold(
            getString(
                R.string.sold_in,
                product.soldInCountries.joinToString()
            )
        )
        ingredients.setTextBold(
            getString(
                R.string.ingredients,
                product.ingredients.joinToString()
            )
        )
        allergens.setTextBold(
            getString(
                R.string.allergens,
                product.allergens.joinToString()
            )
        )
        additives.setTextBold(
            getString(
                R.string.additives,
                product.additives.joinToString()
            )
        )
        Picasso.get()
            .load(product.urlImage)
            .error(R.drawable.placeholder)
            .into(dishImage)
    }


    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }

}