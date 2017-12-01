package com.example.fabia.campanario.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;

import com.example.fabia.campanario.Adapters.StoreAdapter;
import com.example.fabia.campanario.Helpers.DataBase;
import com.example.fabia.campanario.Models.Category;
import com.example.fabia.campanario.Models.PertaintoCategory;
import com.example.fabia.campanario.Models.Store;
import com.example.fabia.campanario.Persistence.PersistenceData;
import com.example.fabia.campanario.R;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;


public class StoreFragment extends Fragment {
    private StoreAdapter storeAdapter;
    private GridView grid_Store;
    private PersistenceData persistenceData;


    public StoreFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewStore = inflater.inflate(R.layout.fragment_store, container, false);
        SugarContext.init(getContext());

        int category = getArguments().getInt("category");
        persistenceData = new PersistenceData(getContext());



        if (!persistenceData.isSaveCategory()) {
            saveCategory();
            System.out.println("Se guardaron las categorias");
        }else{
            System.out.println("no se guardo la informacion\n*******\n***\n***");
        }

        if (!persistenceData.isSaveStore()) {
            saveStore();
            System.out.println("Se guardaron las tiendas");

        }else{
            System.out.println("no se guardo la informacion\n*******\n***\n***");
        }
        storeAdapter = new StoreAdapter(this.getActivity(), loadStore(category));
        grid_Store = (GridView) viewStore.findViewById(R.id.grid_store_category);
        grid_Store.setAdapter(storeAdapter);

        return viewStore;
    }

    private void saveStore() {
        Category category1=Category.findByName(getString(R.string.menu_title_food_drink));
        Store store1=new Store("Capriccio", "8323053", "Local: 25", "https://campanariopopayan.com/images/tiendas/tiendas/capriccio.png");
       Store store2=new Store("Copoazu", "323-30-9237", "Local: (Kiosko Techo) KT4", "https://campanariopopayan.com/images/tiendas/tiendas/copoazu.png");
        Store store3=new Store("Frisby", "8367957", "Local: C10", "https://campanariopopayan.com/images/tiendas/tiendas/frisby-1371577815.jpg");
        Store store4=new Store("Hamburguesas El Corral", "8323082", "Local: C9", "https://campanariopopayan.com/images/tiendas/tiendas/hamburguesas-el-corral-1371577533.jpg");
        Store store5=new Store("Helados MIMO'S", "8323157", "Local: 68", "https://campanariopopayan.com/images/tiendas/tiendas/helados-mimos-1371575246.jpg");
        Store store6=new Store("Helados POPSY", "314-359-0967", "Local: 49", "https://campanariopopayan.com/images/tiendas/tiendas/helados-popsy-1371575109.jpg");
        Store store7=new Store("La Fontana", "8242760", "Local: C13", "https://campanariopopayan.com/images/tiendas/tiendas/la-fontana.png");
        Store store8=new Store("La Locura", "8323272", "Local: C11", "https://campanariopopayan.com/images/tiendas/tiendas/la-locura-1371577714.jpg");
        Store store9=new Store("Más Tragos", "8323131", "Local: (Kiosko Bar) KB8", "https://campanariopopayan.com/images/tiendas/tiendas/mas-tragos.png");
        Store store10=new Store("Pedro Parrilla", "", "Local: C20", "https://campanariopopayan.com/images/tiendas/tiendas/pedro-parrilla-1496855090.jpg");
        Store store11=new Store("Presto", "8323118", "Local: C6", "https://campanariopopayan.com/images/tiendas/tiendas/presto-1371577010.jpg");
        Store store12=new Store("Rincon Jumbo", "3162047181", "Local: ", "https://campanariopopayan.com/images/tiendas/tiendas/rincon-jumbo-1504537398.jpg");
        Store store13=new Store("San Blas", "301-432-2370", "Local: (Kiosko bar) KB4", "https://campanariopopayan.com/images/tiendas/tiendas/san-blass.png");
        Store store14=new Store("Sandwich Cubano", "8323095", "Local: C5", "https://campanariopopayan.com/images/tiendas/tiendas/sandwich-cubano-1371576758.jpg");
        Store store15=new Store("Sr. Wok", "8323162", "Local: C4", "https://campanariopopayan.com/images/tiendas/tiendas/sr-wok-1371576858.jpg");
        Store store16=new Store("Tacos & Bar.BQ", "8323282", "Local: C8", "https://campanariopopayan.com/images/tiendas/tiendas/tacos-barbq-1371577269.jpg");
        Store store17=new Store("Tierra Blanca", "312-765-0199", "Local: (Kiosko Bar) KB5", "https://campanariopopayan.com/images/tiendas/tiendas/tierra-blanca.png");
        Store store18=new Store("Urabana", "8353529", "Local: C-2", "https://campanariopopayan.com/images/tiendas/tiendas/urabana-1421771051.jpg");
        store1.save();
        store2.save();
        store3.save();
        store4.save();
        store5.save();
        store6.save();
        store7.save();
        store8.save();
        store9.save();
        store10.save();
        store11.save();
        store12.save();
        store13.save();
        store14.save();
        store15.save();
        store16.save();
        store17.save();
        store18.save();
        PertaintoCategory.save(new PertaintoCategory(store1,category1));
        PertaintoCategory.save(new PertaintoCategory(store2,category1));
       PertaintoCategory.save(new PertaintoCategory(store3,category1));
        PertaintoCategory.save(new PertaintoCategory(store4,category1));
        PertaintoCategory.save(new PertaintoCategory(store5,category1));
        PertaintoCategory.save(new PertaintoCategory(store6,category1));
        PertaintoCategory.save(new PertaintoCategory(store7,category1));
        PertaintoCategory.save(new PertaintoCategory(store8,category1));
        PertaintoCategory.save(new PertaintoCategory(store9,category1));
        PertaintoCategory.save(new PertaintoCategory(store10,category1));
        PertaintoCategory.save(new PertaintoCategory(store11,category1));
        PertaintoCategory.save(new PertaintoCategory(store12,category1));
        PertaintoCategory.save(new PertaintoCategory(store13,category1));
        PertaintoCategory.save(new PertaintoCategory(store14,category1));
        PertaintoCategory.save(new PertaintoCategory(store15,category1));
        PertaintoCategory.save(new PertaintoCategory(store16,category1));
        PertaintoCategory.save(new PertaintoCategory(store17,category1));
        PertaintoCategory.save(new PertaintoCategory(store18,category1));

        Category category2=Category.findByName(getString(R.string.menu_title_fashion));
        Store store21=new Store("Adrissa", "8353590", "Local: 30", "https://campanariopopayan.com/images/tiendas/tiendas/adrissa-1399132373.jpg" );
        Store store22=new Store("Aquiles", "8361050", "Local: 67", "https://campanariopopayan.com/images/tiendas/tiendas/aquiles-1371573592.jpg" );
        Store store23=new Store("Armi", "8323020", "Local: 80 y 81", "https://campanariopopayan.com/images/tiendas/tiendas/armi-1371580973.jpg" );
        Store store24=new Store("Arturo Calle", "8323015, 8237029", "Local: 39", "https://campanariopopayan.com/images/tiendas/tiendas/arturo-calle-1371579861.jpg" );
        Store store25=new Store("Bazar Hindú", "8323146", "Local: 61", "https://campanariopopayan.com/images/tiendas/tiendas/bazar-hindu.png" );
        Store store26=new Store("Bkul", "8323021", "Local: 37", "https://campanariopopayan.com/images/tiendas/tiendas/bkul-1371579416.jpg" );
        Store store27=new Store("Bubble Gummers", "----", "Local: 87 y 88", "https://campanariopopayan.com/images/tiendas/tiendas/bubble-gummers-1502315512.jpg" );
        Store store28=new Store("Calzado Bosi", "8323101", "Local: 13", "https://campanariopopayan.com/images/tiendas/tiendas/calzado-bosi-1371573075.jpg" );
        Store store29=new Store("Calzado Isabella", "8323170", "Local: 75", "https://campanariopopayan.com/images/tiendas/tiendas/calzado-isabella.png" );
        Store store210=new Store("Calzado Josh", "8238232", "Local: 20", "https://campanariopopayan.com/images/tiendas/tiendas/calzado-josh-1371573820.jpg" );
        Store store211=new Store("Calzatodo", "8203942", "Local: 50 y 51", "https://campanariopopayan.com/images/tiendas/tiendas/calzatodo-1371573662.jpg" );
        Store store212=new Store("Celio*", "8204500", "Local: 5 y 6", "https://campanariopopayan.com/images/tiendas/tiendas/celio-1452611481.jpg" );
        Store store213=new Store("Chevignon", "----", "Local: 21", "https://campanariopopayan.com/images/tiendas/tiendas/chevignon-1371578908.jpg" );
        Store store214=new Store("Criss Vélez", "----", "Local: 212 C Segundo piso", "https://campanariopopayan.com/images/tiendas/tiendas/criss-velez-1508006660.jpg" );
        Store store215=new Store("Croquet", "-----", "Local: 86", "https://campanariopopayan.com/images/tiendas/tiendas/croquet-1371581186.jpg" );
        Store store216=new Store("Deportech", "8339602", "Local: 44", "https://campanariopopayan.com/images/tiendas/tiendas/deportech-1494371391.jpg" );
        Store store217=new Store("Esprit", "8202828", "Local: 79", "https://campanariopopayan.com/images/tiendas/tiendas/esprit-1437684012.jpg" );
        Store store218=new Store("Feria del Brasier y solo Kuko's", "8323143", "Local: 29", "https://campanariopopayan.com/images/tiendas/tiendas/feria-del-brasier-y-solo-kukos-1371578258.jpg" );
        Store store219=new Store("Fuera de serie FDS", "8232821", "Local: 19", "https://campanariopopayan.com/images/tiendas/tiendas/fuera-de-serie-fds-1395947876.jpg" );
        Store store220=new Store("Ibis", "8201457", "Local: 65", "https://campanariopopayan.com/images/tiendas/tiendas/ibis-1371580542.jpg" );
        Store store221=new Store("Studio F", "8323060", "Local: 94", "https://campanariopopayan.com/images/tiendas/tiendas/studio-f-1371581505.jpg" );
        store21.save();
        store22.save();
        store23.save();
        store24.save();
        store25.save();
        store26.save();
        store27.save();
        store28.save();
        store29.save();
        store210.save();
        store211.save();
        store212.save();
        store213.save();
        store214.save();
        store215.save();
        store216.save();
        store217.save();
        store218.save();
        store219.save();
        store220.save();
        store221.save();
        PertaintoCategory.save(new PertaintoCategory(store21,category2));
        PertaintoCategory.save(new PertaintoCategory(store22, category2));
        PertaintoCategory.save(new PertaintoCategory(store23, category2));
        PertaintoCategory.save(new PertaintoCategory(store24, category2));
        PertaintoCategory.save(new PertaintoCategory(store25, category2));
        PertaintoCategory.save(new PertaintoCategory(store26, category2));
        PertaintoCategory.save(new PertaintoCategory(store27, category2));
        PertaintoCategory.save(new PertaintoCategory(store28, category2));
        PertaintoCategory.save(new PertaintoCategory(store29, category2));
        PertaintoCategory.save(new PertaintoCategory(store210, category2));
        PertaintoCategory.save(new PertaintoCategory(store211, category2));
        PertaintoCategory.save(new PertaintoCategory(store212, category2));
        PertaintoCategory.save(new PertaintoCategory(store213, category2));
        PertaintoCategory.save(new PertaintoCategory(store214, category2));
        PertaintoCategory.save(new PertaintoCategory(store215, category2));
        PertaintoCategory.save(new PertaintoCategory(store216, category2));
        PertaintoCategory.save(new PertaintoCategory(store217, category2));
        PertaintoCategory.save(new PertaintoCategory(store218, category2));
        PertaintoCategory.save(new PertaintoCategory(store219, category2));
        PertaintoCategory.save(new PertaintoCategory(store220, category2));
        PertaintoCategory.save(new PertaintoCategory(store221, category2));

        Category category3=Category.findByName(getString(R.string.menu_title_home_technology));
        Store store31=new Store("Claro", "8369999", "Local: 54,55 y 56", "https://campanariopopayan.com/images/tiendas/tiendas/claro-1371574244.jpg" );
        Store store32=new Store("Colchones Comodísimos", "8201174", "Local: 85", "https://campanariopopayan.com/images/tiendas/tiendas/colchones-comodisimos-1457551116.jpg" );
        Store store33=new Store("Colchones Spring", "8339659", "Local: 58", "https://campanariopopayan.com/images/tiendas/tiendas/colchones-spring-1477768224.jpg" );
        Store store34=new Store("Electrocréditos del Cauca", "8353339", "Local: 52", "https://campanariopopayan.com/images/tiendas/tiendas/electrocreditos-del-cauca.png" );
        Store store35=new Store("Foto Japón", "8323142", "Local: 83", "https://campanariopopayan.com/images/tiendas/tiendas/foto-japon-1371574641.jpg" );
        Store store36=new Store("Surtitodo", "PBX(4) 4444489 EXT: 2", "Local: 212G (Segundo Piso Amplicación)", "https://campanariopopayan.com/images/tiendas/tiendas/surtitodo-1489090671.jpg" );
        Store store37=new Store("Telefónica Movistar", "8204904", "Local: Exterior I", "https://campanariopopayan.com/images/tiendas/tiendas/telefonica-movistar-1371574167.jpg" );
        store31.save();
        store32.save();
        store33.save();
        store34.save();
        store35.save();
        store36.save();
        store37.save();
        PertaintoCategory.save(new PertaintoCategory(store31,category3));
        PertaintoCategory.save(new PertaintoCategory(store32, category3));
        PertaintoCategory.save(new PertaintoCategory(store33, category3));
        PertaintoCategory.save(new PertaintoCategory(store34, category3));
        PertaintoCategory.save(new PertaintoCategory(store35, category3));
        PertaintoCategory.save(new PertaintoCategory(store36, category3));
        PertaintoCategory.save(new PertaintoCategory(store37, category3));


        Category category4=Category.findByName(getString(R.string.menu_title_accessories));
        Store store41=new Store("Ático Niños", "8323001", "Local: 31", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store42=new Store("Baby Fresh", "-----", "Local: 122", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store43=new Store("Bubble Gummers", "----", "Local: 87 y 88", "https://campanariopopayan.com/images/tiendas/tiendas/bubble-gummers-1502315512.jpg" );
        Store store44=new Store("Femeni", "8232062", "Local: 89", "https://campanariopopayan.com/images/tiendas/tiendas/femeni.png" );
        Store store45=new Store("Foto Japón", "8323142", "Local: 83", "https://campanariopopayan.com/images/tiendas/tiendas/foto-japon-1371574641.jpg" );
        Store store46=new Store("Kairos", "------", "Local: 102", "https://campanariopopayan.com/images/tiendas/tiendas/kairos-1480375706.jpg" );
        Store store47=new Store("La Riviera", "8323210", "Local: 38", "https://campanariopopayan.com/images/tiendas/tiendas/la-riviera-1371572551.jpg" );
        Store store48=new Store("Malú", "3012508608", "Local: (Burbuja) B2", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store49=new Store("Offcorss", "8236085", "Local: 16", "https://campanariopopayan.com/images/tiendas/tiendas/offcorss-1452611410.jpg" );
        Store store410=new Store("Òptica Colombiana", "8323149", "Local: 78", "https://campanariopopayan.com/images/tiendas/tiendas/optica-colombiana-1371576395.jpg" );
        Store store411=new Store("Patú detalles y màs", "8323275", "Local: 63", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store412=new Store("Pepe Ganga", "------", "Local: Ancla IA", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store413=new Store("Perfumex", "315-349-2676", "Local: (Kiosko Techo) KT6", "https://campanariopopayan.com/images/tiendas/tiendas/perfumex.png" );
        Store store414=new Store("Platería Ramírez", "8323267", "Local: 7 y 8", "https://campanariopopayan.com/images/tiendas/tiendas/plateria-ramirez-1371571331.jpg" );
        Store store415=new Store("Platería Tiffany", "8323161", "Local: 27", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store416=new Store("Praga Calidad en Cueros", "8232250", "Local: 64", "https://campanariopopayan.com/images/tiendas/tiendas/praga-cueros.png" );
        Store store417=new Store("Senthia", "-----", "Local: (Burbuja) B7", "https://campanariopopayan.com/images/tiendas/tiendas/senthia-1389988708.jpg" );
        Store store418=new Store("Totto Tú", "3113037321", "Local: 76", "https://campanariopopayan.com/images/tiendas/tiendas/totto-tu-1371578806.jpg" );
        Store store419=new Store("Velez", "8323062", "Local: 41,42, 104", "https://campanariopopayan.com/images/tiendas/tiendas/cueros-velez-1371573203.jpg" );
        store41.save();
        store42.save();
        store43.save();
        store44.save();
        store45.save();
        store46.save();
        store47.save();
        store48.save();
        store49.save();
        store410.save();
        store411.save();
        store412.save();
        store413.save();
        store414.save();
        store415.save();
        store416.save();
        store417.save();
        store418.save();
        store419.save();
        PertaintoCategory.save(new PertaintoCategory(store41,category4));
        PertaintoCategory.save(new PertaintoCategory(store42, category4));
        PertaintoCategory.save(new PertaintoCategory(store43, category4));
        PertaintoCategory.save(new PertaintoCategory(store44, category4));
        PertaintoCategory.save(new PertaintoCategory(store45, category4));
        PertaintoCategory.save(new PertaintoCategory(store46, category4));
        PertaintoCategory.save(new PertaintoCategory(store47, category4));
        PertaintoCategory.save(new PertaintoCategory(store48, category4));
        PertaintoCategory.save(new PertaintoCategory(store49, category4));
        PertaintoCategory.save(new PertaintoCategory(store410, category4));
        PertaintoCategory.save(new PertaintoCategory(store411, category4));
        PertaintoCategory.save(new PertaintoCategory(store412, category4));
        PertaintoCategory.save(new PertaintoCategory(store413, category4));
        PertaintoCategory.save(new PertaintoCategory(store414, category4));
        PertaintoCategory.save(new PertaintoCategory(store415, category4));
        PertaintoCategory.save(new PertaintoCategory(store416, category4));
        PertaintoCategory.save(new PertaintoCategory(store417, category4));
        PertaintoCategory.save(new PertaintoCategory(store418, category4));
        PertaintoCategory.save(new PertaintoCategory(store419, category4));



        Category category5=Category.findByName(getString(R.string.menu_title_entertainment));
         Store store51=new Store("Bubble Gummers", "----", "Local: 87 y 88", "https://campanariopopayan.com/images/tiendas/tiendas/bubble-gummers-1502315512.jpg" );
         Store store52=new Store("Play Point", "8323260", "Local: -----", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
         Store store53=new Store("Royal Films", "8372974", "Local: 33", "https://campanariopopayan.com/images/tiendas/tiendas/royal-films-1371575019.jpg" );
         Store store54=new Store("Tango Casino", "8367940", "Local: 53", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        store51.save();
        store52.save();
        store53.save();
        store54.save();
        PertaintoCategory.save(new PertaintoCategory(store51,category2));
        PertaintoCategory.save(new PertaintoCategory(store52, category2));
        PertaintoCategory.save(new PertaintoCategory(store53, category2));
        PertaintoCategory.save(new PertaintoCategory(store54, category2));

        Category category6=Category.findByName(getString(R.string.menu_title_others));
        Store store61=new Store("Administración del Centro C.", "8353505", "Local: Oficina 208", "https://campanariopopayan.com/images/tiendas/tiendas/administracion.png" );
        Store store62=new Store("Amadeo Cerón Abogados", "8234091,320-689-7414", "Local: Oficina 205", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store63=new Store("Banco Av Villas", "8323070", "Local: 43", "https://campanariopopayan.com/images/tiendas/tiendas/banco-av-villas-1371572017.jpg" );
        Store store64=new Store("Banco Davivienda", "8323105", "Local: 9,10 y 11", "https://campanariopopayan.com/images/tiendas/tiendas/banco-davivienda-1371571754.jpg" );
        Store store65=new Store("Banco de Bogotá", "8323220", "Local: 40", "https://campanariopopayan.com/images/tiendas/tiendas/bango-de-bogota-1371571923.jpg" );
        Store store66=new Store("Bancolombia", "8325988 , 8331383", "Local: 36", "https://campanariopopayan.com/images/tiendas/tiendas/bancolombia-1371571839.jpg" );
        Store store67=new Store("Claro - OFICINA", "8369999", "Local: Oficina 306", "https://campanariopopayan.com/images/tiendas/tiendas/claro-oficina-1371581370.jpg" );
        Store store68=new Store("Colmena", "8202292, 8202477", "Local: Oficina 206", "https://campanariopopayan.com/images/tiendas/tiendas/colmena-1371576177.jpg" );
        Store store69=new Store("Constructora Arinsa", "8203655, 88234763", "Local: Oficina 301 y 302", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store610=new Store("Consultoria Isabel Cristina Gómez", "-----", "Local: Oficina 203", "https://campanariopopayan.com/images/tiendas/tiendas/consultorio-isabel-cristina-gomez-1449337174.jpg" );
        Store store611=new Store("Coopechance", "8242606", "Local: (Kiosko Techo) KT2", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store612=new Store("Cutis, Droguería Dermatológica", "8201090", "Local: 26", "https://campanariopopayan.com/images/tiendas/tiendas/cutis-drogueria-dermatologica-1371574865.jpg" );
        Store store613=new Store("Drogas la Rebaja Mini Market", "8323032, 8323033 y 8323034", "Local: Exterior Panamericana", "https://campanariopopayan.com/images/tiendas/tiendas/mini-market-drogas-la-rebaja-1371574729.jpg" );
        Store store614=new Store("G y G Inversiones", "8323159", "Local: Oficina 307", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store615=new Store("Interventoría y Construcción", "8323272", "Local: Oficina 202", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store616=new Store("Juguemos", "8327171", "Local: (Burbuja) B1 Y B6", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store617=new Store("Praga Turismo", "8200327", "Local: CE4", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        Store store618=new Store("Unidad Administrativa Especial para la consolidacion territorial", "------", "Local: Oficina 208", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg" );
        store61.save();
        store62.save();
        store63.save();
        store64.save();
        store65.save();
        store66.save();
        store67.save();
        store68.save();
        store69.save();
        store610.save();
        store611.save();
        store612.save();
        store613.save();
        store614.save();
        store615.save();
        store616.save();
        store617.save();
        store618.save();
        PertaintoCategory.save(new PertaintoCategory(store61,category6));
        PertaintoCategory.save(new PertaintoCategory(store62, category6));
        PertaintoCategory.save(new PertaintoCategory(store63, category6));
        PertaintoCategory.save(new PertaintoCategory(store64, category6));
        PertaintoCategory.save(new PertaintoCategory(store65, category6));
        PertaintoCategory.save(new PertaintoCategory(store66, category6));
        PertaintoCategory.save(new PertaintoCategory(store67, category6));
        PertaintoCategory.save(new PertaintoCategory(store68, category6));
        PertaintoCategory.save(new PertaintoCategory(store69, category6));
        PertaintoCategory.save(new PertaintoCategory(store610, category6));
        PertaintoCategory.save(new PertaintoCategory(store611, category6));
        PertaintoCategory.save(new PertaintoCategory(store612, category6));
        PertaintoCategory.save(new PertaintoCategory(store613, category6));
        PertaintoCategory.save(new PertaintoCategory(store614, category6));
        PertaintoCategory.save(new PertaintoCategory(store615, category6));
        PertaintoCategory.save(new PertaintoCategory(store616, category6));
        PertaintoCategory.save(new PertaintoCategory(store617, category6));
        PertaintoCategory.save(new PertaintoCategory(store618, category6));


        Category category7=Category.findByName(getString(R.string.menu_title_hypermarket));
         Store store71=new Store("Jumbo", "Nacional 01-8000-112-036", "Local:", "https://campanariopopayan.com/images/tiendas/categorias/hipermecado-1371581913.jpg" );
        store71.save();
        PertaintoCategory.save(new PertaintoCategory(store71,category7));





        persistenceData.setSaveStore(true);


    }

    private void saveCategory(){
        SugarRecord.save(new Category(getString(R.string.menu_title_food_drink)));
        SugarRecord.save(new Category(getString(R.string.menu_title_fashion)));
        SugarRecord.save(new Category(getString(R.string.menu_title_home_technology)));
        SugarRecord.save(new Category(getString(R.string.menu_title_accessories)));
        SugarRecord.save(new Category(getString(R.string.menu_title_entertainment)));
        SugarRecord.save(new Category(getString(R.string.menu_title_hypermarket)));
        SugarRecord.save(new Category(getString(R.string.menu_title_others)));

        /*Category category1=new Category(getString(R.string.menu_title_food_drink));
        Category category2=new Category(getString(R.string.menu_title_fashion));
        Category category3=new Category(getString(R.string.menu_title_home_technology));
        Category category4=new Category(getString(R.string.menu_title_accessories));
        Category category5=new Category(getString(R.string.menu_title_entertainment));
        Category category6=new Category(getString(R.string.menu_title_hypermarket));
        Category category7=new Category(getString(R.string.menu_title_others));
        category1.save();
        category2.save();
        category3.save();
        category4.save();
        category5.save();
        category6.save();
        category7.save();*/
        persistenceData.setSaveCategory(true);
    }

    private ArrayList<Store> loadStore2() {
        ArrayList<Store> listStore;
        listStore = (ArrayList<Store>) Store.listAll(Store.class);
        return listStore;


    }
    private ArrayList<Store> loadStore(int category){
        ArrayList<Store> listStore = new ArrayList<>();
        switch (category) {
            case R.id.item_food_drink:
                listStore=(ArrayList<Store>) PertaintoCategory.findStoreByCategory(getString(R.string.menu_title_food_drink));

                break;
            case R.id.item_fashion:
                listStore=(ArrayList<Store>) PertaintoCategory.findStoreByCategory(getString(R.string.menu_title_fashion));


                break;
            case R.id.item_home_technology:
                listStore=(ArrayList<Store>) PertaintoCategory.findStoreByCategory(getString(R.string.menu_title_home_technology));

                break;
            case R.id.item_accessories:
                listStore=(ArrayList<Store>) PertaintoCategory.findStoreByCategory(getString(R.string.menu_title_accessories));

                break;
            case R.id.item_entertainment:
                listStore=(ArrayList<Store>) PertaintoCategory.findStoreByCategory(getString(R.string.menu_title_entertainment));

                break;
            case R.id.item_others:
                listStore=(ArrayList<Store>) PertaintoCategory.findStoreByCategory(getString(R.string.menu_title_others));

                break;
            case R.id.item_hypermarket:
                listStore=(ArrayList<Store>) PertaintoCategory.findStoreByCategory(getString(R.string.menu_title_hypermarket));

                break;

            default:
                break;


        }
        return listStore;
    }
    private ArrayList<Store> chargeStore(int category) {
        // String category1=this.getActivity().getResources().getString(R.string.menu_title_food_drink);
        ArrayList<Store> listStore = new ArrayList<>();
        switch (category) {
            case R.id.item_food_drink:
                listStore.add(new Store("Capriccio", "8323053", "Local: 25", "https://campanariopopayan.com/images/tiendas/tiendas/capriccio.png"));
                listStore.add(new Store("Copoazu", "323-30-9237", "Local: (Kiosko Techo) KT4", "https://campanariopopayan.com/images/tiendas/tiendas/copoazu.png"));
                listStore.add(new Store("Frisby", "8367957", "Local: C10", "https://campanariopopayan.com/images/tiendas/tiendas/frisby-1371577815.jpg"));
                listStore.add(new Store("Hamburguesas El Corral", "8323082", "Local: C9", "https://campanariopopayan.com/images/tiendas/tiendas/hamburguesas-el-corral-1371577533.jpg"));
                listStore.add(new Store("Helados MIMO'S", "8323157", "Local: 68", "https://campanariopopayan.com/images/tiendas/tiendas/helados-mimos-1371575246.jpg"));
                listStore.add(new Store("Helados POPSY", "314-359-0967", "Local: 49", "https://campanariopopayan.com/images/tiendas/tiendas/helados-popsy-1371575109.jpg"));
                listStore.add(new Store("La Fontana", "8242760", "Local: C13", "https://campanariopopayan.com/images/tiendas/tiendas/la-fontana.png"));
                listStore.add(new Store("La Locura", "8323272", "Local: C11", "https://campanariopopayan.com/images/tiendas/tiendas/la-locura-1371577714.jpg"));
                listStore.add(new Store("Más Tragos", "8323131", "Local: (Kiosko Bar) KB8", "https://campanariopopayan.com/images/tiendas/tiendas/mas-tragos.png"));
                listStore.add(new Store("Pedro Parrilla", "", "Local: C20", "https://campanariopopayan.com/images/tiendas/tiendas/pedro-parrilla-1496855090.jpg"));
                listStore.add(new Store("Presto", "8323118", "Local: C6", "https://campanariopopayan.com/images/tiendas/tiendas/presto-1371577010.jpg"));
                listStore.add(new Store("Rincon Jumbo", "3162047181", "Local: ", "https://campanariopopayan.com/images/tiendas/tiendas/rincon-jumbo-1504537398.jpg"));
                listStore.add(new Store("San Blas", "301-432-2370", "Local: (Kiosko bar) KB4", "https://campanariopopayan.com/images/tiendas/tiendas/san-blass.png"));
                listStore.add(new Store("Sandwich Cubano", "8323095", "Local: C5", "https://campanariopopayan.com/images/tiendas/tiendas/sandwich-cubano-1371576758.jpg"));
                listStore.add(new Store("Sr. Wok", "8323162", "Local: C4", "https://campanariopopayan.com/images/tiendas/tiendas/sr-wok-1371576858.jpg"));
                listStore.add(new Store("Tacos & Bar.BQ", "8323282", "Local: C8", "https://campanariopopayan.com/images/tiendas/tiendas/tacos-barbq-1371577269.jpg"));
                listStore.add(new Store("Tierra Blanca", "312-765-0199", "Local: (Kiosko Bar) KB5", "https://campanariopopayan.com/images/tiendas/tiendas/tierra-blanca.png"));
                listStore.add(new Store("Urabana", "8353529", "Local: C-2", "https://campanariopopayan.com/images/tiendas/tiendas/urabana-1421771051.jpg"));
                break;
            case R.id.item_fashion:
                listStore.add(new Store("Adrissa", "8353590", "Local: 30", "https://campanariopopayan.com/images/tiendas/tiendas/adrissa-1399132373.jpg"));
                listStore.add(new Store("Aquiles", "8361050", "Local: 67", "https://campanariopopayan.com/images/tiendas/tiendas/aquiles-1371573592.jpg"));
                listStore.add(new Store("Armi", "8323020", "Local: 80 y 81", "https://campanariopopayan.com/images/tiendas/tiendas/armi-1371580973.jpg"));
                listStore.add(new Store("Arturo Calle", "8323015, 8237029", "Local: 39", "https://campanariopopayan.com/images/tiendas/tiendas/arturo-calle-1371579861.jpg"));
                listStore.add(new Store("Bazar Hindú", "8323146", "Local: 61", "https://campanariopopayan.com/images/tiendas/tiendas/bazar-hindu.png"));
                listStore.add(new Store("Bkul", "8323021", "Local: 37", "https://campanariopopayan.com/images/tiendas/tiendas/bkul-1371579416.jpg"));
                listStore.add(new Store("Bubble Gummers", "----", "Local: 87 y 88", "https://campanariopopayan.com/images/tiendas/tiendas/bubble-gummers-1502315512.jpg"));
                listStore.add(new Store("Calzado Bosi", "8323101", "Local: 13", "https://campanariopopayan.com/images/tiendas/tiendas/calzado-bosi-1371573075.jpg"));
                listStore.add(new Store("Calzado Isabella", "8323170", "Local: 75", "https://campanariopopayan.com/images/tiendas/tiendas/calzado-isabella.png"));
                listStore.add(new Store("Calzado Josh", "8238232", "Local: 20", "https://campanariopopayan.com/images/tiendas/tiendas/calzado-josh-1371573820.jpg"));
                listStore.add(new Store("Calzatodo", "8203942", "Local: 50 y 51", "https://campanariopopayan.com/images/tiendas/tiendas/calzatodo-1371573662.jpg"));
                listStore.add(new Store("Celio*", "8204500", "Local: 5 y 6", "https://campanariopopayan.com/images/tiendas/tiendas/celio-1452611481.jpg"));
                listStore.add(new Store("Chevignon", "----", "Local: 21", "https://campanariopopayan.com/images/tiendas/tiendas/chevignon-1371578908.jpg"));
                listStore.add(new Store("Criss Vélez", "----", "Local: 212 C Segundo piso", "https://campanariopopayan.com/images/tiendas/tiendas/criss-velez-1508006660.jpg"));
                listStore.add(new Store("Croquet", "-----", "Local: 86", "https://campanariopopayan.com/images/tiendas/tiendas/croquet-1371581186.jpg"));
                listStore.add(new Store("Deportech", "8339602", "Local: 44", "https://campanariopopayan.com/images/tiendas/tiendas/deportech-1494371391.jpg"));
                listStore.add(new Store("Esprit", "8202828", "Local: 79", "https://campanariopopayan.com/images/tiendas/tiendas/esprit-1437684012.jpg"));
                listStore.add(new Store("Feria del Brasier y solo Kuko's", "8323143", "Local: 29", "https://campanariopopayan.com/images/tiendas/tiendas/feria-del-brasier-y-solo-kukos-1371578258.jpg"));
                listStore.add(new Store("Fuera de serie FDS", "8232821", "Local: 19", "https://campanariopopayan.com/images/tiendas/tiendas/fuera-de-serie-fds-1395947876.jpg"));
                listStore.add(new Store("Ibis", "8201457", "Local: 65", "https://campanariopopayan.com/images/tiendas/tiendas/ibis-1371580542.jpg"));
                listStore.add(new Store("Studio F", "8323060", "Local: 94", "https://campanariopopayan.com/images/tiendas/tiendas/studio-f-1371581505.jpg"));


                break;
            case R.id.item_home_technology:
                listStore.add(new Store("Claro", "8369999", "Local: 54,55 y 56", "https://campanariopopayan.com/images/tiendas/tiendas/claro-1371574244.jpg"));
                listStore.add(new Store("Colchones Comodísimos", "8201174", "Local: 85", "https://campanariopopayan.com/images/tiendas/tiendas/colchones-comodisimos-1457551116.jpg"));
                listStore.add(new Store("Colchones Spring", "8339659", "Local: 58", "https://campanariopopayan.com/images/tiendas/tiendas/colchones-spring-1477768224.jpg"));
                listStore.add(new Store("Electrocréditos del Cauca", "8353339", "Local: 52", "https://campanariopopayan.com/images/tiendas/tiendas/electrocreditos-del-cauca.png"));
                listStore.add(new Store("Foto Japón", "8323142", "Local: 83", "https://campanariopopayan.com/images/tiendas/tiendas/foto-japon-1371574641.jpg"));
                listStore.add(new Store("Surtitodo", "PBX(4) 4444489 EXT: 2", "Local: 212G (Segundo Piso Amplicación)", "https://campanariopopayan.com/images/tiendas/tiendas/surtitodo-1489090671.jpg"));
                listStore.add(new Store("Telefónica Movistar", "8204904", "Local: Exterior I", "https://campanariopopayan.com/images/tiendas/tiendas/telefonica-movistar-1371574167.jpg"));
                break;
            case R.id.item_accessories:
                listStore.add(new Store("Ático Niños", "8323001", "Local: 31", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Baby Fresh", "-----", "Local: 122", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Bubble Gummers", "----", "Local: 87 y 88", "https://campanariopopayan.com/images/tiendas/tiendas/bubble-gummers-1502315512.jpg"));
                listStore.add(new Store("Femeni", "8232062", "Local: 89", "https://campanariopopayan.com/images/tiendas/tiendas/femeni.png"));
                listStore.add(new Store("Foto Japón", "8323142", "Local: 83", "https://campanariopopayan.com/images/tiendas/tiendas/foto-japon-1371574641.jpg"));
                listStore.add(new Store("Kairos", "------", "Local: 102", "https://campanariopopayan.com/images/tiendas/tiendas/kairos-1480375706.jpg"));
                listStore.add(new Store("La Riviera", "8323210", "Local: 38", "https://campanariopopayan.com/images/tiendas/tiendas/la-riviera-1371572551.jpg"));
                listStore.add(new Store("Malú", "3012508608", "Local: (Burbuja) B2", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Offcorss", "8236085", "Local: 16", "https://campanariopopayan.com/images/tiendas/tiendas/offcorss-1452611410.jpg"));
                listStore.add(new Store("Òptica Colombiana", "8323149", "Local: 78", "https://campanariopopayan.com/images/tiendas/tiendas/optica-colombiana-1371576395.jpg"));
                listStore.add(new Store("Patú detalles y màs", "8323275", "Local: 63", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Pepe Ganga", "------", "Local: Ancla IA", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Perfumex", "315-349-2676", "Local: (Kiosko Techo) KT6", "https://campanariopopayan.com/images/tiendas/tiendas/perfumex.png"));
                listStore.add(new Store("Platería Ramírez", "8323267", "Local: 7 y 8", "https://campanariopopayan.com/images/tiendas/tiendas/plateria-ramirez-1371571331.jpg"));
                listStore.add(new Store("Platería Tiffany", "8323161", "Local: 27", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Praga Calidad en Cueros", "8232250", "Local: 64", "https://campanariopopayan.com/images/tiendas/tiendas/praga-cueros.png"));
                listStore.add(new Store("Senthia", "-----", "Local: (Burbuja) B7", "https://campanariopopayan.com/images/tiendas/tiendas/senthia-1389988708.jpg"));
                listStore.add(new Store("Totto Tú", "3113037321", "Local: 76", "https://campanariopopayan.com/images/tiendas/tiendas/totto-tu-1371578806.jpg"));
                listStore.add(new Store("Velez", "8323062", "Local: 41,42, 104", "https://campanariopopayan.com/images/tiendas/tiendas/cueros-velez-1371573203.jpg"));
                break;
            case R.id.item_entertainment:
                listStore.add(new Store("Bubble Gummers", "----", "Local: 87 y 88", "https://campanariopopayan.com/images/tiendas/tiendas/bubble-gummers-1502315512.jpg"));
                listStore.add(new Store("Play Point", "8323260", "Local: -----", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Royal Films", "8372974", "Local: 33", "https://campanariopopayan.com/images/tiendas/tiendas/royal-films-1371575019.jpg"));
                listStore.add(new Store("Tango Casino", "8367940", "Local: 53", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                break;
            case R.id.item_others:
                listStore.add(new Store("Administración del Centro C.", "8353505", "Local: Oficina 208", "https://campanariopopayan.com/images/tiendas/tiendas/administracion.png"));
                listStore.add(new Store("Amadeo Cerón Abogados", "8234091,320-689-7414", "Local: Oficina 205", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Banco Av Villas", "8323070", "Local: 43", "https://campanariopopayan.com/images/tiendas/tiendas/banco-av-villas-1371572017.jpg"));
                listStore.add(new Store("Banco Davivienda", "8323105", "Local: 9,10 y 11", "https://campanariopopayan.com/images/tiendas/tiendas/banco-davivienda-1371571754.jpg"));
                listStore.add(new Store("Banco de Bogotá", "8323220", "Local: 40", "https://campanariopopayan.com/images/tiendas/tiendas/bango-de-bogota-1371571923.jpg"));
                listStore.add(new Store("Bancolombia", "8325988 , 8331383", "Local: 36", "https://campanariopopayan.com/images/tiendas/tiendas/bancolombia-1371571839.jpg"));
                listStore.add(new Store("Claro - OFICINA", "8369999", "Local: Oficina 306", "https://campanariopopayan.com/images/tiendas/tiendas/claro-oficina-1371581370.jpg"));
                listStore.add(new Store("Colmena", "8202292, 8202477", "Local: Oficina 206", "https://campanariopopayan.com/images/tiendas/tiendas/colmena-1371576177.jpg"));
                listStore.add(new Store("Constructora Arinsa", "8203655, 88234763", "Local: Oficina 301 y 302", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Consultoria Isabel Cristina Gómez", "-----", "Local: Oficina 203", "https://campanariopopayan.com/images/tiendas/tiendas/consultorio-isabel-cristina-gomez-1449337174.jpg"));
                listStore.add(new Store("Coopechance", "8242606", "Local: (Kiosko Techo) KT2", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Cutis, Droguería Dermatológica", "8201090", "Local: 26", "https://campanariopopayan.com/images/tiendas/tiendas/cutis-drogueria-dermatologica-1371574865.jpg"));
                listStore.add(new Store("Drogas la Rebaja Mini Market", "8323032, 8323033 y 8323034", "Local: Exterior Panamericana", "https://campanariopopayan.com/images/tiendas/tiendas/mini-market-drogas-la-rebaja-1371574729.jpg"));
                listStore.add(new Store("G y G Inversiones", "8323159", "Local: Oficina 307", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Interventoría y Construcción", "8323272", "Local: Oficina 202", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Juguemos", "8327171", "Local: (Burbuja) B1 Y B6", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Praga Turismo", "8200327", "Local: CE4", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                listStore.add(new Store("Unidad Administrativa Especial para la consolidacion territorial", "------", "Local: Oficina 208", "https://campanariopopayan.com/images/tiendas/tiendas/tienda-campanario.jpg"));
                break;
            case R.id.item_hypermarket:
                listStore.add(new Store("Jumbo", "Nacional 01-8000-112-036", "Local:", "https://campanariopopayan.com/images/tiendas/categorias/hipermecado-1371581913.jpg"));
                break;

            default:
                break;


        }
        return listStore;

    }


}
