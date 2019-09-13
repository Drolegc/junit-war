package uytube.views.usuarios.consultar;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javassist.tools.framedump;
import uytube.UsuarioController.UsuarioController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import uytube.models.Usuario;
import uytube.views.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import uytube.views.usuarios.UserMain;
import uytube.views.usuarios.consultar.Consultar;;
public class ConsultarMain extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	private String [] nombreColumnas = {"Nombre","Apellido","Nickname","Correo","F.Nac"};
	private String [][] datos ;
	private JTable table_1;
	private JFrame frame;
	private Usuario user;
	public ConsultarMain() {
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 430, 230);
		add(scrollPane);
		
		UsuarioController controller = new UsuarioController();
		ArrayList<Usuario> usuarios = controller.listaUsuarios();
		DefaultTableModel  tablemodel = new DefaultTableModel(nombreColumnas, 0);
		table = new JTable();
		for(Usuario u:usuarios) {
			tablemodel.addRow(
					new Object[] {
							u.getNombre(),
							u.getApellido(),
							u.getNickname(),
							u.getCorreo(),
							u.getFnacimiento()
					}
			);
		}
		
		table.setModel(tablemodel);
		scrollPane.setViewportView(table);
		
		JButton btnEditarUsuario = new JButton("Consultar usuario");
		btnEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar consultar = new Consultar(user);
				Frame.frame.setContentPane(consultar);
				Frame.frame.revalidate();

			}
		});
		btnEditarUsuario.setBounds(336, 269, 104, 21);
		btnEditarUsuario.setVisible(false);
		add(btnEditarUsuario);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				user = usuarios.get(e.getFirstIndex());
				btnEditarUsuario.setVisible(true);
			}
		});
		
		

	}
}
