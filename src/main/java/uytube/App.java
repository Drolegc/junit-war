package uytube;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Transaction;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

import uytube.CategoriaController.CategoriaController;
import uytube.CategoriaController.ICategoria;
import uytube.ComentarioController.ComentarioController;
import uytube.ListaController.ILista;
import uytube.ListaController.ListaController;
import uytube.UsuarioController.IUsuario;
import uytube.UsuarioController.UsuarioController;
import uytube.VideoController.IVideo;
import uytube.VideoController.VideoController;
import uytube.models.Canal;
import uytube.models.Comentario;
import uytube.models.HibernateUtil;
import uytube.models.Usuario;
import uytube.models.Video;
import uytube.views.Frame;
import uytube.views.Inicio;
import uytube.views.categorias.alta;
import uytube.views.categorias.consulta;
import uytube.views.categorias.listar;
import uytube.views.listas.AgregarVideo1;
import uytube.views.listas.QuitarVideo1;
import uytube.views.listas.ConsultaListasUsuario;
import uytube.views.listas.crear;
import uytube.views.listas.modificar;

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import uytube.views.usuarios.Alta;
import uytube.views.usuarios.Buscar;
import uytube.views.usuarios.DejarSeguir;
import uytube.views.usuarios.Listar;
import uytube.views.usuarios.Seguir;
import uytube.views.usuarios.consultar.ConsultarMain;
import uytube.views.videos.AltaComentario;
import uytube.views.usuarios.editar.ListadoEditar;
import uytube.views.videos.AltaVideo;
import uytube.views.videos.ConsultaVideo;
import uytube.views.videos.ModificarDatosVideo;
import uytube.views.videos.ValorarVideo;

import org.hibernate.Session;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class App extends JFrame{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);	
					frame.setTitle("Uytube - ADMINISTRADOR");
					//frame.setSize(900, 400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		ICategoria controllerCategoria = new CategoriaController();
		controllerCategoria.altaCategoria("Sin Categoria");
		controllerCategoria.altaCategoria("Estilo de vida");
		controllerCategoria.altaCategoria("Musica");
		controllerCategoria.altaCategoria("Ciencia");
		controllerCategoria.altaCategoria("Tecnologia");
		controllerCategoria.altaCategoria("Vlog");
		controllerCategoria.altaCategoria("Virales");
		
		
		System.out.println("Fin");
	}

	/**
	 * Create the frame.
	 */
	public App() {
		Frame.frame = this;	
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(dim.width/2-this.getSize().width/2, 0, 820, 550);
		Inicio inicio = new Inicio();
		inicio.setBounds(0, 0, 814, 1);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		getContentPane().add(inicio);
		
		JLabel lblUytubeAdministrador = new JLabel("UYTUBE ADMINISTRADOR");
		lblUytubeAdministrador.setBounds(10, 76, 165, 14);
		getContentPane().add(lblUytubeAdministrador);
		
		JTextArea txtrUtilizeLosMenus = new JTextArea();
		txtrUtilizeLosMenus.setForeground(Color.BLACK);
		txtrUtilizeLosMenus.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		txtrUtilizeLosMenus.setWrapStyleWord(true);
		txtrUtilizeLosMenus.setLineWrap(true);
		txtrUtilizeLosMenus.setText("Utilize los menus para ingresar a las diferentes funciones de el administrador de la plataforma.\r\n\r\n- Usuarios - Aqui podra dar de alta, consultar(permite modificar el usuario), seguir usuario, dejar de seguir usuario y listar usuarios de la plataforma.\r\n\r\n-Videos - Esta categoria concierne en cuanto a los datos de los videos, agregar, modificar valorar, consultar y comentar los videos de la plataforma.\r\n\r\n- Categorias - En la seccion de categorias, el administrador  puede agregar, consultar y listar las mismas. \r\n\r\n- Listas - Por ultimo, en el menu de listas se puede crear, consultar y listar las listas de los usuarios de Uytube. Estas pueden ser las listas default o particulares.\r\n\r\n#  |'\u00AF\u00AF|\u00AF\u00AF'|\u00B0\\\u00AF\u00AF\u00AF|\u00AF\u00AF\u00AF/||\u00AF\u00AF\u00AF\u00AF\u00AF|\u00B0|'\u00AF\u00AF|\u00AF\u00AF'|\u00B0|\u00AF\u00AF\u00AF|      /\u00AFx\u00AF\u00AF\\ \r\n#  |        |  \\       /  |       | |      | |    \u00AF\u00AF\\'|   (\\__/|\r\n#   \\____/ '   |____|'   \u00AF|__|\u00AF   \\____/ '|__x__/\u00B0 \\____\\   ");
		txtrUtilizeLosMenus.setBounds(10, 99, 782, 313);
		getContentPane().add(txtrUtilizeLosMenus);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAgregarUsuario = new JMenuItem("Agregar usuario");
		mntmAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alta alta = new Alta();
				Frame.frame.setContentPane(alta);
				Frame.frame.revalidate();
			}
		});
		mnUsuarios.add(mntmAgregarUsuario);
		
		JMenuItem mntmConsultarUsuario = new JMenuItem("Consultar usuario");
		mntmConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarMain consultar = new ConsultarMain();
				Frame.frame.setContentPane(consultar);
				Frame.frame.revalidate();		
			}
		});
		mnUsuarios.add(mntmConsultarUsuario);

		JMenuItem mntmEditarUsuario = new JMenuItem("Editar usuarios");
		mntmEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEditar editar = new ListadoEditar();
				Frame.frame.setContentPane(editar);
				Frame.frame.revalidate();		
			}
		});
		mnUsuarios.add(mntmEditarUsuario);		
		JMenuItem mntmListarUsuarios = new JMenuItem("Listar usuarios");
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar listar = new Listar();
				Frame.frame.setContentPane(listar);
				Frame.frame.revalidate();	
			}
		});
		mnUsuarios.add(mntmListarUsuarios);
		
		JMenuItem mntmSeguirUsuario = new JMenuItem("Seguir usuario");
		mntmSeguirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seguir seguir = new Seguir();
				Frame.frame.setContentPane(seguir);
				Frame.frame.revalidate();	
			}
		});
		mnUsuarios.add(mntmSeguirUsuario);
		
		JMenuItem mntmDejarDeSeguir = new JMenuItem("Dejar de seguir ");
		mntmDejarDeSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DejarSeguir dejarSeguir = new DejarSeguir();
				Frame.frame.setContentPane(dejarSeguir);
				Frame.frame.revalidate();
			}
		});
		mntmDejarDeSeguir.setHorizontalAlignment(SwingConstants.LEFT);
		mnUsuarios.add(mntmDejarDeSeguir);
		
		JMenu mnNewMenu = new JMenu("Videos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAgregarVideo = new JMenuItem("Agregar video");
		mntmAgregarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaVideo altaV = new AltaVideo();
				Frame.frame.setContentPane(altaV);
				Frame.frame.revalidate();
			}
		});
		mnNewMenu.add(mntmAgregarVideo);
		
		JMenuItem mntmModificarVideo = new JMenuItem("Modificar video");
		mntmModificarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarDatosVideo ModifVideo = new ModificarDatosVideo();
				Frame.frame.setContentPane(ModifVideo);
				Frame.frame.revalidate();
			}
		});
		mnNewMenu.add(mntmModificarVideo);
		
		JMenuItem mntmValorarVideo = new JMenuItem("Valorar video");
		mntmValorarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValorarVideo valorov = new ValorarVideo();
				Frame.frame.setContentPane(valorov);
				Frame.frame.revalidate();
			}
		});
		mnNewMenu.add(mntmValorarVideo);
		
		JMenuItem mntmVisualizar = new JMenuItem("Consulta de video ");
		mntmVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVideo consultaV = new ConsultaVideo();
				Frame.frame.setContentPane(consultaV);
				Frame.frame.revalidate();
			}
		});
		mnNewMenu.add(mntmVisualizar);
		
		JMenuItem mntmComentarUnVideo = new JMenuItem("Comentar un video");
		mntmComentarUnVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaComentario altaC = new AltaComentario();
				Frame.frame.setContentPane(altaC);
				Frame.frame.revalidate();
			}
		});
		mnNewMenu.add(mntmComentarUnVideo);
		
		JMenu mnCategorias = new JMenu("Categorias");
		menuBar.add(mnCategorias);
		
		JMenuItem mntmAgregarCategoria = new JMenuItem("Agregar categoria");
		mntmAgregarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta alta = new alta();
				Frame.frame.setContentPane(alta);
				Frame.frame.revalidate();
			}
		});
		mnCategorias.add(mntmAgregarCategoria);
		
		JMenuItem mntmConsultarCategoria = new JMenuItem("Consultar categoria");
		mntmConsultarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta con = new consulta();
				Frame.frame.setContentPane(con);
				Frame.frame.revalidate();
			}
		});
		mnCategorias.add(mntmConsultarCategoria);
		
		JMenuItem mntmListarCategorias = new JMenuItem("Listar categorias");
		mntmListarCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar lista = new listar();
				Frame.frame.setContentPane(lista);
				Frame.frame.revalidate();
			}
		});
		mnCategorias.add(mntmListarCategorias);
		
		JMenu mnListas = new JMenu("Listas");
		menuBar.add(mnListas);
		
		JMenuItem mntmCrearLista = new JMenuItem("Crear lista");
		mntmCrearLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear listas = new crear();
				Frame.frame.setContentPane(listas);
				Frame.frame.validate();
			}
		});
		mnListas.add(mntmCrearLista);
		
		JMenuItem mntmModificarLista = new JMenuItem("Modificar lista");
		mntmModificarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar mod = new modificar();
				Frame.frame.setContentPane(mod);
				Frame.frame.revalidate();
			}
		});
		mnListas.add(mntmModificarLista);
		
		JMenuItem mntmAgregarVideoLista= new JMenuItem("Agregar video");
		mntmAgregarVideoLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarVideo1 addVid = new AgregarVideo1();
				Frame.frame.setContentPane(addVid);
				Frame.frame.revalidate();
			}
		});
		mnListas.add(mntmAgregarVideoLista);
		
		JMenuItem mntmBorrarVideoLista= new JMenuItem("Borrar video");
		mntmBorrarVideoLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuitarVideo1 deleteVid = new QuitarVideo1();
				Frame.frame.setContentPane(deleteVid);
				Frame.frame.revalidate();
			}
		});
		mnListas.add(mntmBorrarVideoLista);
		
		
		JMenuItem mntmListarListas = new JMenuItem("Consulta de listas");
		mntmListarListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uytube.views.listas.consulta listarLU = new uytube.views.listas.consulta();
				Frame.frame.setContentPane(listarLU);
				Frame.frame.revalidate();
			}
		});
		mnListas.add(mntmListarListas);
	}
}
