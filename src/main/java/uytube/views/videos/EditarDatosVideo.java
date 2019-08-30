package uytube.views.videos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

import uytube.UsuarioController.UsuarioController;
import uytube.models.Usuario;
import uytube.models.Video;
import uytube.views.Frame;
import uytube.views.usuarios.Listar;
import javax.swing.JComboBox;

public class EditarDatosVideo extends JPanel {

	/**
	 * Create the panel.
	 * @param video 
	 */
	
	
	private JTextField userInfo;
	private JTextField titulo;
	private JTextField duracion;
	private JTextField url;
	private JTextField descrip;
	private VideoMain main;
	private Video videito;
	private String userInfoStr;
	private String catAsignar;
	private JTextField nickname;
	private JTextField nombre;
	private JTextField descripcion;
	private JTextField duracion1;
	private JDateChooser fecPub;
	
	public EditarDatosVideo(Video video) {
		
		
			setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("30px"),
					ColumnSpec.decode("148px"),
					ColumnSpec.decode("83px"),
					ColumnSpec.decode("71px:grow"),
					FormSpecs.UNRELATED_GAP_COLSPEC,
					ColumnSpec.decode("69px"),},
				new RowSpec[] {
					FormSpecs.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("13px"),
					FormSpecs.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("19px"),
					FormSpecs.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("13px"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("19px"),
					FormSpecs.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("13px"),
					FormSpecs.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("19px"),
					RowSpec.decode("52px"),
					RowSpec.decode("21px"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,}));
			JLabel lblNickname = new JLabel("usuario/nickname");
			add(lblNickname, "2, 2, left, top");
			
			this.userInfo = new JTextField();
			add(userInfo, "2, 4, fill, top");
			this.userInfo.setColumns(10);
			this.userInfo.setEditable(false);
			this.userInfo.setText(video.getCanal().getNombre());
			
			JLabel lblUrl = new JLabel("URL");
			add(lblUrl, "4, 2, left, top");
			this.url = new JTextField();
			this.url.setColumns(10);
			this.url.setText(video.getUrl());
			add(url, "4, 4, 3, 1, fill, top");
			
			JLabel lblNombre = new JLabel("Titulo");
			add(lblNombre, "2, 8, left, top");
			
			JLabel lblDescripcion = new JLabel("Descripcion");
			add(lblDescripcion, "4, 8, left, top");
			
			this.titulo = new JTextField();
			add(titulo, "2, 10, fill, top");
			this.titulo.setColumns(10);
			this.titulo.setText(video.getNombre());
			
			this.descripcion = new JTextField();
			this.descripcion.setColumns(10);
			add(descripcion, "4, 10, 3, 1, fill, top");
			this.descripcion.setText(video.getDescripcion());
			
			this.duracion = new JTextField();
			this.duracion.setColumns(10);
			this.duracion.setText(video.getDuracion());
			add(duracion, "2, 14, fill, top");
			
			JLabel lblDuracion = new JLabel("Duracion");
			add(lblDuracion, "2, 12, left, top");
			
			JLabel lblFechaPublicacion = new JLabel("Fecha publicacion");
			add(lblFechaPublicacion, "4, 12, left, top");
			
			fecPub = new JDateChooser();
			fecPub.setDate(video.getFecha());
			add(fecPub, "4, 14, 3, 1, fill, top");
			
			JButton btnCancelar = new JButton("cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VideoMain videos = new VideoMain();
					Frame.frame.setContentPane(videos);
					Frame.frame.validate();
				}
			});
			
			JLabel lblCategoria = new JLabel("Categoria");
			add(lblCategoria, "4, 15");
			
			JComboBox categoriaAsig = new JComboBox();
			
			add(categoriaAsig, "4, 16, fill, default");
			add(btnCancelar, "2, 18, default, top");
			
			
			JButton btnAgregar = new JButton("Editar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Usuario modelUsuario = new Usuario();
					modelUsuario.setNickname(nickname.getText());
					modelUsuario.setApellido(descripcion.getText());
					modelUsuario.setNombre(nombre.getText());
					modelUsuario.setCorreo(url.getText());
					modelUsuario.setFnacimiento(fecPub.getDate());
					modelUsuario.setImg(duracion1.getText());
					UsuarioController Controlerusuario = new UsuarioController();
					Controlerusuario.modificarUsuario(modelUsuario);
					Listar listar = new Listar();
					JOptionPane.showMessageDialog(Frame.frame, "Usuario Editado");
					Frame.frame.setContentPane(listar);
					Frame.frame.revalidate();
				}
			});
			add(btnAgregar, "4, 18, 3, 1, default, top");
		}
}


	


