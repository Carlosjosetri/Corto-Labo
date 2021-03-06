package vista;

import dao.Movieda;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.movie;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame {

    
    public JLabel lblnombre, lblDirector, lblanio, lblenproyeccion;
    
    public JTextField Nombre, descripcion, stock;
    public JComboBox director;
    
    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton buscar, eliminar, insertar, limpiar, actualizar;
    
    private static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblnombre);
        container.add(lblDirector);
        container.add(lblanio);
        container.add(lblenproyeccion);
        container.add(Nombre);
        container.add(director);
        container.add(stock);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(800, 600);
        eventos();
    }

    private void agregarLabels() {
        lblnombre = new JLabel("Nombre");
        lblDirector = new JLabel("director");
        lblanio = new JLabel("anio");
        lblenproyeccion = new JLabel("en proyeccion");
        lblnombre.setBounds(10, 10, ANCHOC, ALTOC);
        lblDirector.setBounds(10, 60, ANCHOC, ALTOC);
        lblanio.setBounds(10, 100, ANCHOC, ALTOC);
        lblenproyeccion.setBounds(10, 140, ANCHOC, ALTOC);
    }

    private void formulario() {
        //elementos
        Nombre = new JTextField();
        director = new JComboBox();
        stock = new JTextField();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");
        
        table = new JPanel();
        
        //agregar elementos al combox director
        director.addItem("FRAM");
        director.addItem("WIX");
        director.addItem("Luber Finer");
        director.addItem("OSK");
        
        //agregando los radio a un grupo
        existencia = new ButtonGroup();
        existencia.add(si);
        existencia.add(no);
        
        Nombre.setBounds(140, 10, ANCHOC, ALTOC);
        director.setBounds(140, 60, ANCHOC, ALTOC);
        stock.setBounds(140, 100, ANCHOC, ALTOC);
        si.setBounds(140, 140, 50, ALTOC);
        no.setBounds(210, 140, 50, ALTOC);
        
        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 210, ANCHOC, ALTOC);
        actualizar.setBounds(150, 210, ANCHOC, ALTOC);
        eliminar.setBounds(300, 210, ANCHOC, ALTOC);
        limpiar.setBounds(450, 210, ANCHOC, ALTOC);
        resultados = new JTable();
        table.setBounds(10, 250, 500, 200);
        table.add(new JScrollPane(resultados));
        
        
    }

    private void llenarTabla() {
        //aca se coloca el tipo de dato que tendra nuestras columnas 
        //si es un dato booleano aparecera un checkbox en el JTABLE
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return int.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return Boolean.class;
                }
                return null;
            }
        };
        //agregamos las columnas que se mostraran con su respectivo nombre
        tm.addColumn("Nombre");
        tm.addColumn("director");
        tm.addColumn("anio");
        tm.addColumn("Clasificaion");
        tm.addColumn("pais");
        tm.addColumn("en_proyecion");
        
        //realizamos la consulta a nuestra base de datos por medio del metodo 
        Movieda fd = new Movieda();
        ArrayList<movie> movies = fd.readAll();
        
        //agregamos el resultado a nuestro JTable
        //se agregan de tipo Object
        for (movie fi : movies){
            tm.addRow(new Object[]{fi.getNombre(), fi.getDirector(), fi.getAnio(),fi.getClasificacion(),fi.getPais(), fi.getEn_proyeccion()});
        }
        
        //le agregamos el modelo de nuestra tabla
        resultados.setModel(tm);
    }

    private void eventos() {
        //insertar
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movieda fd = new Movieda();
                movie f = new movie( Integer.parseInt(stock.getText()),Nombre.getText(),Nombre.getText(),Nombre.getText(),Nombre.getText(),Integer.parseInt(stock.getText()),true);
                
                if(no.isSelected()){
                    f.setEn_proyeccion(false);
                }
                
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null, "movie registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de modificar el filtro");
                }
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movieda fd = new Movieda();
                movie f = new movie(Integer.parseInt(stock.getText()),Nombre.getText(),Nombre.getText(),Nombre.getText(),Nombre.getText(),Integer.parseInt(stock.getText()),true);
                
                if(no.isSelected()){
                   f.setEn_proyeccion(false);
                }
                
                if(fd.update(f)){
                    JOptionPane.showMessageDialog(null, "movie modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de modificar el movie");
                }
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movieda fd = new Movieda();
                if(fd.delete(Nombre.getText())){
                    JOptionPane.showMessageDialog(null, "Filtro eliminado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema a momento de eliminar el movie");
                }
            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movieda fd = new Movieda();
                movie f = fd.read(Nombre.getText());
                if(f == null){
                    JOptionPane.showMessageDialog(null, "El movie buscado no se ha encontrado");
                } else {
                    Nombre.setText(f.getNombre());
                    director.setSelectedItem(f.getDirector());
                    stock.setText(Integer.toString(f.getAnio()));
                    
                    if(f.getEn_proyeccion()){
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }
            }
        });
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }
    
    private void limpiarCampos() {
        Nombre.setText(" ");
        director.setSelectedItem("carlos");
        stock.setText(" ");
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }
    
}
