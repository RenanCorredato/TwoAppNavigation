package com.renancorredato.twoappnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.renancorredato.twoappnavigation.databinding.FragmentProductDetailsBinding

class ProductDetails : Fragment() {

    private val args: ProductDetailsArgs by navArgs()

    private lateinit var binding: FragmentProductDetailsBinding

    private val product = arrayListOf(
        Product(
            name = "Bolacha Recheada",
            description = "Biscoitos com sabores irresistíveis, que " +
                    "aliam qualidade e alta tecnologia de produção. Krokero" +
                    " é a marca de biscoito que cabe na mesa e no bolso do " +
                    "consumidor, pois possui excelente custo benefício. " +
                    "Krokero, eu quero!",
            price = "R$ 10,00"
        ),
        Product(
            name = "Bolo de Chocolate",
            description = "Biscoitos com sabores irresistíveis, que " +
                    "aliam qualidade e alta tecnologia de produção. Krokero" +
                    " é a marca de biscoito que cabe na mesa e no bolso do " +
                    "consumidor, pois possui excelente custo benefício. " +
                    "Krokero, eu quero!",
            price = "R$ 60,00"
        ),
        Product(
            name = "Bolacha Salgada",
            description = "Biscoitos com sabores irresistíveis, que " +
                    "aliam qualidade e alta tecnologia de produção. Krokero" +
                    " é a marca de biscoito que cabe na mesa e no bolso do " +
                    "consumidor, pois possui excelente custo benefício. " +
                    "Krokero, eu quero!",
            price = "R$ 20,00"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val id = requireArguments().getInt("ID")
        val id = args.id
//        val user = args.user
//        user.id  objeto de uma tela para outro
//        user.name

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        if (id >= product.size) {
            binding.tvName.text = "Produto inválido"
            binding.tvDescription.visibility = View.GONE
            binding.tvPrice.visibility = View.GONE
            return
        }

        val product = product[id]

        binding.tvName.text = product.name
        binding.tvDescription.text = product.description
        binding.tvPrice.text = product.price
    }
}