package com.example.dashboard;

import com.example.dashboard.entities.*;
import com.example.dashboard.entities.enums.Estado;
import com.example.dashboard.entities.enums.FormaPago;
import com.example.dashboard.entities.enums.TipoEnvio;
import com.example.dashboard.entities.enums.TipoPromocion;
import com.example.dashboard.repositories.*;
import com.example.dashboard.entities.Empresa;
import com.example.dashboard.entities.Sucursal;
import com.example.dashboard.repositories.EmpresaRepository;
import com.example.dashboard.repositories.SucursalRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@SpringBootApplication
public class DashboardApplication {

	private static final Logger logger = LoggerFactory.getLogger(DashboardApplication.class);

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private SucursalRepository sucursalRepository;

	@Autowired
	private PromocionRepository promocionRepository;

	@Autowired
	private ImagenRepository imagenRepository;

	@Autowired
	private ArticuloRepository articuloRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;



	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}


	@Bean
	CommandLineRunner init(PedidoRepository pedidoRepository,
						   FacturaRepository facturaRepository) {

		return args -> {
			logger.info("----------------ESTOY----FUNCIONANDO---------------------");

			//Crear instancia pais
			Pais pais = Pais.builder().nombre("Argentina").build();

			//Crear instancias provincias
			Provincia provincia1 = Provincia.builder().nombre("Mendoza").pais(pais).build();
			Provincia provincia2 = Provincia.builder().nombre("Cordoba").pais(pais).build();

			//Crear instancias localidades
			Localidad localidad1 = Localidad.builder().nombre("Guaymallen").provincia(provincia1).build();
			Localidad localidad2 = Localidad.builder().nombre("Godoy Cruz").provincia(provincia1).build();
			Localidad localidad3 = Localidad.builder().nombre("Lujan de Cuyo").provincia(provincia1).build();

			paisRepository.save(pais);
			provinciaRepository.save(provincia1);
			provinciaRepository.save(provincia2);
			localidadRepository.save(localidad1);
			localidadRepository.save(localidad2);
			localidadRepository.save(localidad3);


			Empresa empresaBrown = Empresa.builder().nombre("Lo de Brown").cuil(30503167).razonSocial("Venta de Alimentos").build();
			Sucursal sucursalChacras = Sucursal.builder().nombre("En chacras").horarioApertura(LocalTime.of(17,0)).horarioCierre(LocalTime.of(23,0)).build();
			Sucursal sucursalGodoyCruz = Sucursal.builder().nombre("En godoy cruz").horarioApertura(LocalTime.of(16,0)).horarioCierre(LocalTime.of(23,30)).build();

			//Crear instancias domicilio
			Domicilio domicilioGodoyCruz = Domicilio.builder()
					.calle("Av. San Martin")
					.numero(1234)
					.cp(5501)
					.piso(5)
					.nroDpto(2)
					.localidad(localidad2)
					.build();

			Domicilio domicilioChacras = Domicilio.builder()
					.calle("Mitre")
					.numero(1634)
					.cp(5505)
					.piso(0)
					.nroDpto(0)
					.localidad(localidad3)
					.build();

			Domicilio domicilioCliente = Domicilio.builder()
					.calle("comodoro rivadavia")
					.numero(1470)
					.cp(5519)
					.piso(0)
					.nroDpto(0)
					.localidad(localidad1)
					.build();
			// Guarda los domicilios en la base de datos
//			domicilioRepository.save(domicilioChacras);
//			domicilioRepository.save(domicilioGodoyCruz);
//			domicilioRepository.save(domicilioCliente);
// 			no hace falta guardar los domicilios porque se guarda cuando esta asociado a otro objeto

			// Asigna los domicilios a las sucursales después de guardarlos
			sucursalChacras.setDomicilio(domicilioChacras);
			sucursalGodoyCruz.setDomicilio(domicilioGodoyCruz);

			// Guardar la empresa en la base de datos
			empresaRepository.save(empresaBrown);

			// Asignar la empresa a las sucursales
			sucursalChacras.setEmpresa(empresaBrown);
			sucursalGodoyCruz.setEmpresa(empresaBrown);

			// Guardar las sucursales en la base de datos
			sucursalRepository.save(sucursalChacras);
			sucursalRepository.save(sucursalGodoyCruz);


			// Agrega las sucursales a la lista de sucursales de la empresa
			empresaBrown.getSucursales().add(sucursalChacras);
			empresaBrown.getSucursales().add(sucursalGodoyCruz);

			// Guarda las sucursales y la empresa en la base de datos
			sucursalRepository.save(sucursalChacras);
			sucursalRepository.save(sucursalGodoyCruz);
			empresaRepository.save(empresaBrown);


			// Crear Unidades de medida
			UnidadMedida unidadMedidaLitros = UnidadMedida.builder().denominacion("Litros").build();
			UnidadMedida unidadMedidaGramos = UnidadMedida.builder().denominacion("Gramos").build();
			UnidadMedida unidadMedidaCantidad = UnidadMedida.builder().denominacion("Cantidad").build();
			UnidadMedida unidadMedidaPorciones = UnidadMedida.builder().denominacion("Porciones").build();
			unidadMedidaRepository.save(unidadMedidaLitros);
			unidadMedidaRepository.save(unidadMedidaGramos);
			unidadMedidaRepository.save(unidadMedidaCantidad);
			unidadMedidaRepository.save(unidadMedidaPorciones);

			// Crear Categorías de productos y subCategorías de los mismos
			Categoria categoria1 = Categoria.builder()
					.denominacion("Sin categoria padre")
					.build();
			Categoria categoria2 = Categoria.builder()
					.denominacion("Pizzas")
					.build();
			Categoria categoria3 = Categoria.builder()
					.denominacion("Muzzarella")
					.build();
			Categoria categoria4 = Categoria.builder()
					.denominacion("Sandwichs")
					.build();
			Categoria bebida = Categoria.builder()
					.denominacion("Bebida")
					.build();
			Categoria insumos = Categoria.builder()
					.denominacion("Insumos")
					.build();
			categoriaRepository.save(categoria1);
			categoria2.setCategoriaPadre(categoria1);
			categoriaRepository.save(categoria2);
			categoria3.setCategoriaPadre(categoria2);
			categoriaRepository.save(categoria3);
			categoria4.setCategoriaPadre(categoria1);
			categoriaRepository.save(categoria4);
			bebida.setCategoriaPadre(categoria1);
			categoriaRepository.save(bebida);
			insumos.setCategoriaPadre(categoria1);
			categoriaRepository.save(insumos);
			sucursalChacras.getCategorias().add(categoria1);
			sucursalChacras.getCategorias().add(categoria2);
			sucursalGodoyCruz.getCategorias().add(categoria1);
			sucursalGodoyCruz.getCategorias().add(categoria2);

			// Crear Insumos , coca cola , harina , etc
			ArticuloInsumo cocaCola = ArticuloInsumo.insumoBuilder().denominacion("Coca cola").esParaElaborar(false).stockActual(5).unidadMedida(unidadMedidaLitros).stockMaximo(50).precioCompra(50.0).precioVenta(70.0).categoria(bebida).build();
			ArticuloInsumo harina = ArticuloInsumo.insumoBuilder().denominacion("Harina").esParaElaborar(true).stockActual(4).unidadMedida(unidadMedidaGramos).stockMaximo(40).precioCompra(40.0).precioVenta(60.5).categoria(insumos).build();
			ArticuloInsumo queso = ArticuloInsumo.insumoBuilder().denominacion("Queso").esParaElaborar(true).stockActual(20).unidadMedida(unidadMedidaGramos).stockMaximo(50).precioCompra(23.6).precioVenta(66.6).categoria(insumos).build();
			ArticuloInsumo tomate = ArticuloInsumo.insumoBuilder().denominacion("Tomate").esParaElaborar(true).stockActual(20).unidadMedida(unidadMedidaCantidad).stockMaximo(50).precioCompra(23.6).precioVenta(66.6).categoria(insumos).build();
			tomate.setUnidadMedida(unidadMedidaLitros);
			// crear fotos para cada insumo
			Imagen imagenCoca = Imagen.builder().denominacion("https://m.media-amazon.com/images/I/51v8nyxSOYL._SL1500_.jpg").build();
			Imagen imagenHarina = Imagen.builder().denominacion("https://mandolina.co/wp-content/uploads/2023/03/648366622-1024x683.jpg").build();
			Imagen imagenQueso = Imagen.builder().denominacion("https://superdepaso.com.ar/wp-content/uploads/2021/06/SANTAROSA-PATEGRAS-04.jpg").build();
			Imagen imagenTomate = Imagen.builder().denominacion("https://thefoodtech.com/wp-content/uploads/2020/06/Componentes-de-calidad-en-el-tomate-828x548.jpg").build();

			articuloInsumoRepository.save(cocaCola);
			articuloInsumoRepository.save(harina);
			articuloInsumoRepository.save(queso);
			articuloInsumoRepository.save(tomate);

			imagenCoca.setArticuloInsumo(cocaCola);
			imagenRepository.save(imagenCoca);
			imagenHarina.setArticuloInsumo(harina);
			imagenRepository.save(imagenHarina);
			imagenQueso.setArticuloInsumo(queso);
			imagenRepository.save(imagenQueso);
			imagenTomate.setArticuloInsumo(tomate);
			imagenRepository.save(imagenTomate);
			imagenQueso.setArticuloInsumo(queso);
			imagenRepository.save(imagenQueso);


			// Crear Articulos Manufacturados
			ArticuloManufacturado pizzaMuzarella = ArticuloManufacturado.manufacturadoBuilder().denominacion("Pizza Muzarella").descripcion("Una pizza clasica").unidadMedida(unidadMedidaPorciones).precioVenta(130.0).tiempoEstimadoMinutos(15).preparacion("Pasos de preparacion de una muzza de toda la vida").categoria(categoria2).build();
			ArticuloManufacturado pizzaNapolitana = ArticuloManufacturado.manufacturadoBuilder().denominacion("Pizza Napolitana").descripcion("Una pizza clasica napolitana").unidadMedida(unidadMedidaPorciones).precioVenta(150.0).tiempoEstimadoMinutos(15).preparacion("Pasos de preparacion de una pizza napolitana italiana").categoria(categoria2).build();
			pizzaNapolitana.setArticuloInsumo(harina);
			pizzaMuzarella.setArticuloInsumo(queso);
			articuloManufacturadoRepository.save(pizzaMuzarella);
			articuloManufacturadoRepository.save(pizzaNapolitana);

			// Crear fotos para los artículos manufacturados
			Imagen imagenPizzaMuzarella = Imagen.builder().denominacion("https://storage.googleapis.com/fitia-api-bucket/media/images/recipe_images/1002846.jpg").build();
			Imagen imagenPizzaNapolitana = Imagen.builder().denominacion("https://assets.elgourmet.com/wp-content/uploads/2023/03/8metlvp345_portada-pizza-1024x686.jpg.webp").build();
			imagenPizzaMuzarella.setArticuloManufacturado(pizzaMuzarella);
			imagenRepository.save(imagenPizzaMuzarella);
			imagenPizzaNapolitana.setArticuloManufacturado(pizzaNapolitana);
			imagenRepository.save(imagenPizzaNapolitana);

			// Crear promocion para sucursal - Dia de los enamorados
			// Tener en cuenta que esa promocion es exclusivamente para una sucursal determinada d euna empresa determinada
			Promocion promocionDiaEnamorados = Promocion.builder().denominacion("Dia de los Enamorados")
					.fechaDesde(LocalDate.of(2024,2,13))
					.fechaHasta(LocalDate.of(2024,2,15))
					.horaDesde(LocalTime.of(0,0))
					.horaHasta(LocalTime.of(23,59))
					.descripcionDescuento("El descuento que se hace por san valentin, un dia antes y un dia despues")
					.precioPromocional(100.0)
					.tipoPromocion(TipoPromocion.promocion)
					.build();
			promocionDiaEnamorados.getArticulos().add(cocaCola);
			promocionDiaEnamorados.getArticulos().add(pizzaMuzarella);
			promocionRepository.save(promocionDiaEnamorados);


			//Agregar categorias y promociones a sucursales

			sucursalChacras.getPromociones().add(promocionDiaEnamorados);

			sucursalRepository.save(sucursalChacras);
			sucursalRepository.save(sucursalGodoyCruz);

			//Crea un cliente y un usuario
			Imagen imagenCliente = Imagen.builder().denominacion("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRr9cSuAFVgr3rFGMkYgMQ6GDXP1Hy-Cp0Ox9GysWr-gg&s").build();
			imagenRepository.save(imagenCliente);

			Usuario usuario = Usuario.builder().username("pepito123").auth0Id("auth0|abcdef1234567890").build();
			usuarioRepository.save(usuario);

			Cliente cliente = Cliente.builder()
					.nombre("pepito")
					.apellido("perez")
					.telefono("23462452")
					.email("pepitoperez@gmail.com")
					.fechaNacimiento(LocalDate.of(2001,10,8))
					.imagen(imagenCliente)
					.usuario(usuario)
					.build();
			cliente.getDomicilios().add(domicilioCliente);
			clienteRepository.save(cliente);

			logger.info("----------------Sucursal Chacras ---------------------");
			logger.info("{}",sucursalChacras);
			logger.info("----------------Sucursal Godoy Cruz ---------------------");
			logger.info("{}",sucursalGodoyCruz);
			logger.info("----------------Empresa sucursal ---------------------");
			logger.info(sucursalChacras.getEmpresa().getNombre());


			Pedido pedido = Pedido.builder()
					.horaEstimadaFinalizacion(LocalDateTime.now().toLocalTime())
					.total(200.400)
					.totalCosto(10.500)
					.estado(Estado.entregado)
					.tipoEnvio(TipoEnvio.delivery)
					.formaPago(FormaPago.MercadoPago)
					.FechaPedido(LocalDate.now()).build();
			pedido.setDomicilio(domicilioGodoyCruz);
			pedido.setCliente(cliente);
			pedido.setSucursal(sucursalChacras);
			pedidoRepository.save(pedido);

			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(100)
					.articulo(pizzaNapolitana)
					.subTotal(250.50)
					.pedido(pedido).build();
			detallePedidoRepository.save(detallePedido);

			logger.info("----------------Detalle pedido: 100, 250.50 ---------------------");
			logger.info("{}",detallePedido);

			Factura factura = Factura.builder()
					.fechaFacturacion(LocalDate.of(2024,1,10))
					.mpPaymentId(1)
					.mpMerchantOrderId(1)
					.mpPreferenceId("1")
					.mpPaymentType("1")
					.formaPago(FormaPago.MercadoPago)
					.totalVenta(10.00).build();
			factura.setPedido(pedido);
			facturaRepository.save(factura);
			logger.info("---------------- Factura: factura ---------------------");
			logger.info("{}",factura);

			logger.info("----------------Pedido: pedido ---------------------");
			logger.info("{}",pedido);

			// Crear una instancia de ArticuloManufacturado
			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.manufacturadoBuilder()
					.denominacion("Pizza")
					.precioVenta(10.0)
					.unidadMedida(unidadMedidaPorciones) // suponiendo que tengas una instancia de UnidadMedida
					.descripcion("Pizza de pepperoni")
					.tiempoEstimadoMinutos(30)
					.preparacion("Precalentar el horno, agregar los ingredientes y hornear durante 20 minutos.")
					.build();
			articuloManufacturado.setArticuloInsumo(harina);
			articuloManufacturado.setArticuloInsumo(queso);
			articuloManufacturado.setArticuloInsumo(tomate);
			// Guardar en la base de datos
			articuloManufacturadoRepository.save(articuloManufacturado); // Suponiendo que tengas un repositorio llamado articuloManufacturadoRepository

			articuloManufacturadoRepository.save(articuloManufacturado);

			logger.info("---------------- Articulo Manufacturado: articulo manufacturado ---------------------");
			logger.info("{}",articuloManufacturado);

			ArticuloManufacturadoDetalle articuloManufacturadoDetallePizza = ArticuloManufacturadoDetalle.builder()
					.cantidad(2)
					.build();
			articuloManufacturadoDetallePizza.setArticuloInsumo(harina);
			articuloManufacturadoDetallePizza.setArticuloInsumo(queso);
			articuloManufacturadoDetallePizza.setArticuloInsumo(tomate);
			articuloManufacturadoDetallePizza.setArticuloManufacturado(articuloManufacturado);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetallePizza);

			ArticuloManufacturadoDetalle articuloManufacturadoDetallePizzaMuzza = ArticuloManufacturadoDetalle.builder()
					.cantidad(400)
					.build();
			articuloManufacturadoDetallePizzaMuzza.setArticuloInsumo(harina);
			articuloManufacturadoDetallePizzaMuzza.setArticuloInsumo(queso);
			articuloManufacturadoDetallePizzaMuzza.setArticuloInsumo(tomate);
			articuloManufacturadoDetallePizzaMuzza.setArticuloManufacturado(pizzaMuzarella);
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetallePizzaMuzza);

			logger.info("---------------- Articulo Manufacturado Detalle: articulo manufacturado detalle ---------------------");
			logger.info("{}",articuloManufacturadoDetallePizza);

		};
	}
}
