package uytube.views.usuarios.consultar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

import uytube.CategoriaController.CategoriaController;
import uytube.UsuarioController.UsuarioController;
import uytube.VideoController.VideoController;
import uytube.models.Canal;
import uytube.models.Categoria;
import uytube.models.Usuario;
import uytube.models.Video;
import uytube.views.Frame;
import uytube.views.usuarios.Listar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class editarVideo extends JPanel {

	/**
	 * Create the panel.
	 * @param video 
	 */
	
	
	private JTextField userInfo;
	private JTextField titulo;
	private JTextField duracion;
	private JTextField url;
	private JTextField descrip;
	private Video videito;
	private String userInfoStr;
	private String catAsignar;
	private JTextField nickname;
	private JTextField nombre;
	private JTextArea descripcion;
	private JTextField duracion1;
	private JDateChooser fecPub;
	
	public editarVideo(Video video, Usuario user) {
			setLayout(null);
			
			JLabel lblNombre = new JLabel("Titulo del video ");
			lblNombre.setBounds(10, 49, 200, 14);
			add(lblNombre);
			
			this.titulo = new JTextField();
			titulo.setBounds(10, 62, 200, 19);
			add(titulo);
			this.titulo.setColumns(10);
			this.titulo.setText(video.getNombre());
			JLabel lblNickname = new JLabel("usuario/nickname");
			lblNickname.setBounds(10, 92, 200, 13);
			add(lblNickname);
			
			this.userInfo = new JTextField();
			userInfo.setEditable(false);
			userInfo.setBounds(10, 104, 200, 19);
			add(userInfo);
			this.userInfo.setColumns(10);
			this.userInfo.setText(video.getCanal().getNombre());
			
			JLabel lblFechaPublicacion = new JLabel("Fecha publicacion");
			lblFechaPublicacion.setBounds(10, 132, 200, 13);
			add(lblFechaPublicacion);
			
			fecPub = new JDateChooser();
			fecPub.setBounds(9, 145, 201, 19);
			fecPub.setDate(video.getFecha());
			add(fecPub);
			
			JLabel lblDuracion = new JLabel("Duracion");
			lblDuracion.setBounds(10, 175, 194, 13);
			add(lblDuracion);
			
			
			this.duracion = new JTextField();
			duracion.setBounds(10, 187, 200, 19);
			this.duracion.setColumns(10);
			this.duracion.setText(video.getDuracion());
			add(duracion);
			
			JLabel lblDescripcion = new JLabel("Descripcion");
			lblDescripcion.setBounds(220, 49, 200, 14);
			add(lblDescripcion);
			
			this.descripcion = new JTextArea();
			descripcion.setLineWrap(true);
			descripcion.setBounds(220, 64, 221, 59);
			this.descripcion.setColumns(10);
			add(descripcion);
			this.descripcion.setText(video.getDescripcion());
			
			
			
			
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setBounds(220, 131, 201, 14);
			add(lblCategoria);
			
			
			//BOTTON DE ASIGNACION DE CATEGORIA?
			CategoriaController controladorCategoria = new CategoriaController();
			ArrayList<Categoria> categorias = controladorCategoria.listarCategorias();
			
			
			String[] array1 = new String[categorias.size()];
			for(int i = 0; i < array1.length; i++) { 
				array1[i] = categorias.get(i).getNombre(); 
				
				
			};
			catAsignar = "Sin Categoria"; // SI NO TOCA EL BOTON, SIMPLEMENTE LO CARGA COMO SIN CATEGORIAS
			JComboBox categoriaAsig = new JComboBox(array1);
			categoriaAsig.setMaximumRowCount(35);
			categoriaAsig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox comboBox12 = (JComboBox)e.getSource();
					catAsignar = (String)comboBox12.getSelectedItem();
			        System.out.println(catAsignar);
				}
			});
			categoriaAsig.setSelectedIndex(video.getCategoria().getId()-1);
			categoriaAsig.setBounds(220, 145, 221, 19);
			add(categoriaAsig);

			JLabel lblUrl = new JLabel("URL");
			lblUrl.setBounds(10, 217, 430, 13);
			add(lblUrl);
			this.url = new JTextField();
			url.setBounds(11, 230, 430, 19);
			this.url.setColumns(10);
			this.url.setText(video.getUrl());
			add(url);
			
			JButton btnCancelar = new JButton("cancelar");
			btnCancelar.setBounds(10, 277, 200, 23);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					verVideo vervideo = new verVideo(video, user);
					Frame.frame.setContentPane(vervideo);
					Frame.frame.revalidate();
				}
			});
			
			
			
			
		
			
			
			
			
			//add(categoriaAsig, "4, 16, fill, default");
			add(btnCancelar);
			
			JLabel label = new JLabel("EDITAR VIDEO");
			label.setBounds(186, 11, 192, 14);
			add(label);
			
			JCheckBox chckbxNewCheckBox2 = new JCheckBox("Es Privado");
			JCheckBox chckbxNewCheckBox = new JCheckBox("Es Publico");

			chckbxNewCheckBox2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chckbxNewCheckBox.setSelected(!(chckbxNewCheckBox2.isSelected()));	

				}
			});
			chckbxNewCheckBox2.setEnabled(true);
			chckbxNewCheckBox2.setSelected(!(video.getEs_publico()));
			chckbxNewCheckBox2.setBounds(322, 186, 101, 23);
			add(chckbxNewCheckBox2);
			
			
		//	JCheckBox chckbxNewCheckBox = new JCheckBox("Es Publico");
			chckbxNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chckbxNewCheckBox2.setSelected(!(chckbxNewCheckBox.isSelected()));	
				}
			});
			chckbxNewCheckBox.setEnabled(true);
			chckbxNewCheckBox.setSelected(video.getEs_publico());
			chckbxNewCheckBox.setBounds(219, 186, 101, 23);
			add(chckbxNewCheckBox);
			
			
			
			
			
			JButton btnAgregar = new JButton("Guardar cambios");
			btnAgregar.setBounds(220, 277, 221, 23);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Video v = new Video();
					
					v.setId(video.getId());
					v.setCanal(video.getCanal());
					v.setNombre(titulo.getText());
					v.setUrl(url.getText());
					v.setDescripcion(descripcion.getText());
					v.setDuracion(duracion.getText());
					v.setFecha(fecPub.getDate());
					v.setCategoria(video.getCategoria());
					v.setEs_publico(chckbxNewCheckBox.isSelected());
					VideoController ControlerV = new VideoController();
					ControlerV.modificarVideo(v);
					
					
					JOptionPane.showMessageDialog(Frame.frame, "Video Editado");
					verVideo vervideo = new verVideo(video, user);
					Frame.frame.setContentPane(vervideo);
					Frame.frame.revalidate();
				}
			});
			add(btnAgregar);
			
			
			
			
			
			
		}
}


	

