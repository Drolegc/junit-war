package uytube.views.videos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import uytube.CategoriaController.CategoriaController;
import uytube.UsuarioController.UsuarioController;
import uytube.VideoController.VideoController;
import uytube.models.Categoria;
import uytube.models.Usuario;
import uytube.models.Video;
import uytube.models.manager.Manager;
import uytube.views.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AltaVideo extends JPanel {
	private JTextField userInfo;
	private JTextField titulo;
	private JTextField duracion;
	private JTextField url;
	private JTextField descrip;
	private VideoMain main;
	private Video videito;
	private String userInfoStr;
	private String catAsignar;
	
	/**
	 * Create the panel.
	 */

	

	public AltaVideo() {
		main = new VideoMain();
		setLayout(null);
		
		JLabel TITULOPANEL = new JLabel("ALTA VIDEO");
		TITULOPANEL.setBounds(176, 11, 87, 14);
		add(TITULOPANEL);
		
		JLabel lblUsuarioCreador = new JLabel("Usuario creador");
		lblUsuarioCreador.setBounds(30, 48, 89, 14);
		add(lblUsuarioCreador);
		
		JLabel lblTituloVideo = new JLabel("Titulo Video");
		lblTituloVideo.setBounds(30, 104, 89, 14);
		add(lblTituloVideo);
		
		titulo = new JTextField();
		titulo.setBounds(23, 129, 96, 20);
		add(titulo);
		titulo.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(30, 160, 48, 14);
		add(lblDuracion);
		
		duracion = new JTextField();
		duracion.setBounds(23, 185, 96, 20);
		add(duracion);
		duracion.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(297, 48, 48, 14);
		add(lblUrl);
		
		url = new JTextField();
		url.setBounds(275, 73, 96, 20);
		add(url);
		url.setColumns(10);
		
		JLabel descripcion = new JLabel("Descripcion");
		descripcion.setBounds(275, 104, 96, 14);
		add(descripcion);
		
		descrip = new JTextField();
		descrip.setBounds(275, 129, 96, 20);
		add(descrip);
		descrip.setColumns(10);
		
		JLabel lblFechaPublicacion = new JLabel("Fecha Publicacion");
		lblFechaPublicacion.setBounds(275, 160, 96, 14);
		add(lblFechaPublicacion);
		
		JDateChooser fecPub = new JDateChooser();
		fecPub.setBounds(276, 185, 95, 20);
		add(fecPub);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				videito = new Video();
				
				videito.setNombre(titulo.getText());
				videito.setDuracion(duracion.getText());
				videito.setDescripcion(descripcion.getText());
				videito.setUrl(url.getText());
				videito.setFecha(fecPub.getDate());
				
				
				VideoController controladorVideo = new VideoController();
				System.out.println(userInfoStr);
				controladorVideo.altaVideo(videito, userInfoStr, catAsignar);

				JOptionPane.showMessageDialog(null, "Video dado de alta correctamente");
				
				Frame.frame.setContentPane(main);
				Frame.frame.revalidate();
			}
		});
		
		btnOk.setBounds(46, 254, 89, 23);
		add(btnOk);
		
		JLabel lblCategoraopcional = new JLabel("Categoria (Opcional)");
		lblCategoraopcional.setBounds(275, 217, 122, 14);
		add(lblCategoraopcional);
		
		// BOTON DE ASIGNACION DE USUARIO
		
		UsuarioController controladorUsuario = new UsuarioController();
		ArrayList<Usuario> usuarios = controladorUsuario.listaUsuarios();	
		String[] array = new String[usuarios.size()];
		for(int i = 0; i < array.length; i++) {
		    array[i] = usuarios.get(i).getNombre();
		}
		JComboBox userInfo1 = new JComboBox(array);
		
		userInfo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox1 = (JComboBox)e.getSource();
		        userInfoStr = (String)comboBox1.getSelectedItem();
		        System.out.println("ELEG� USER Y ES: "+ userInfoStr);  
				}
		});
		userInfo1.setBounds(23, 73, 96, 22);
		add(userInfo1);
		
		
		//BOTTON DE ASIGNACION DE CATEGORIA
		
		CategoriaController controladorCategoria = new CategoriaController();
		ArrayList<Categoria> categorias = controladorCategoria.listarCategorias();
		
		String[] array1 = new String[categorias.size()];
		for(int i = 0; i < array1.length; i++) {
		    array1[i] = categorias.get(i).getNombre();
		}
		JComboBox categoriaAsig = new JComboBox(array1);
		categoriaAsig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox12 = (JComboBox)e.getSource();
		        catAsignar = (String)comboBox12.getSelectedItem();
		        System.out.println(catAsignar);
			}
		});
		categoriaAsig.setBounds(275, 254, 96, 22);
		add(categoriaAsig);
		
		
		

	}
}
