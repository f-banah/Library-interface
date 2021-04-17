import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.*;


import java.io.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.util.Properties;


public class Livre extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JLabel lbid,lbti,lbgenre,lbaut, lbdate , lbtitre,lbtitre2,labelim;
	JTextField tfid,tftitr , tfgnr, tfaut , tfdate ;
	JButton bsl,bin,bted,bt,bdel,btact;
	ResultSet rst;
	Statement st;
	Connctdb cn=new Connctdb();
	JTable jt;
	JScrollPane js;
	Properties r = new Properties();
	UtilDateModel model = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(model, r);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	String genre[]={"Policier","Fantastique","Science-fiction","roman graphique","Bande Dessinée","Comics & Manga","Religions,Spiritualité","Sciences Humaines","Histoire ,Géographie"};  
	JComboBox gr =new JComboBox(genre);   
	
	public Livre() throws IOException{
		
		
		add(p);
		
		p.setLayout(null);
		
		this.setTitle("Gestion de livres ");
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		lbtitre=new JLabel(" Gestion de livres");
		lbtitre.setBounds(10,40,300,50);
		lbtitre.setFont(new Font("Cambria ",Font.BOLD+Font.ITALIC,30));
		lbtitre.setForeground(new Color(20, 90, 50));
		p.add(lbtitre);
		lbtitre2=new JLabel("La liste des livres :");
		lbtitre2.setBounds(340,150,300,30);
		lbtitre2.setFont(new Font("Cambria ",Font.BOLD+Font.ITALIC,30));
		lbtitre2.setForeground(new Color(20, 90, 50));
		p.add(lbtitre2);
		btact=new JButton("Actualiser");
		btact.setFont(new Font("Cambria ",Font.BOLD+Font.ITALIC,15));
		btact.setForeground(new Color(100, 30, 22));
		btact.setBounds(750,50,110,30);
		btact.addActionListener(this);
		
		p.add(btact);
		p.setBackground(new Color(245, 203, 167));
		lbid=new JLabel("Identifiant");
		lbid.setBounds(10,100,100,30);
		lbid.setFont(new Font("Cambria ",Font.BOLD,15));
		lbid.setForeground(new Color(110, 44, 0 ));
		p.add(lbid);
		tfid=new JTextField();
		tfid.setBounds(150,100,150,30);
		p.add(tfid);
		
	
		bdel=new JButton("Supprimer");
		bdel.setBounds(460,100,120,30);
		bdel.setFont(new Font("Cambria ",Font.BOLD+Font.ITALIC,15));
		bdel.setForeground(new Color(100, 30, 22));
		
		bdel.addActionListener(this);
		p.add(bdel);
		
		bsl=new JButton("Rechercher");
		bsl.setBounds(320,100,120,30);
		bsl.setFont(new Font("Cambria ",Font.BOLD+Font.ITALIC,15));
		bsl.setForeground(new Color(100, 30, 22));
		bsl.addActionListener(this);
		p.add(bsl);
		lbti=new JLabel("Le titre :");
		lbti.setBounds(10,150,100,30);
		lbti.setFont(new Font("Cambria ",Font.BOLD,15));
		lbti.setForeground(new Color(110, 44, 0 ));
		p.add(lbti);
		tftitr=new JTextField();
		tftitr.setBounds(150,150,150,30);
		p.add(tftitr);
		lbgenre=new JLabel("Le gnenre :");
		lbgenre.setBounds(10,200,100,30);
		lbgenre.setFont(new Font("Cambria ",Font.BOLD,15));
		lbgenre.setForeground(new Color(110, 44, 0 ));
		p.add(lbgenre);
		
		
		      
	     
	    gr.setBounds(150,200,150,30);    
	    p.add(gr);        
		
		lbaut=new JLabel("L'auteur :");
		lbaut.setBounds(10,250,100,30);
		lbaut.setFont(new Font("Cambria ",Font.BOLD,15));
		lbaut.setForeground(new Color(110, 44, 0 ));
		p.add(lbaut);
		tfaut=new JTextField();
		tfaut.setBounds(150,250,150,30);
		p.add(tfaut);
		lbdate=new JLabel("La date d'apparition :");
		lbdate.setBounds(10,300,150,30);
		lbdate.setFont(new Font("Cambria ",Font.BOLD,15));
		lbdate.setForeground(new Color(110, 44, 0 ));
		p.add(lbdate);
		
		r.put("text.today", "Today");
        r.put("text.month", "Month");
        r.put("text.year", "Year");
		
		datePicker.setBounds(150,300,150,30);
		p.add(datePicker);
		
		
		tfdate=new JTextField();
		tfdate.setBounds(150,300,150,30);
		
		
		bin=new JButton("Insertion");
		bin.setBounds(100,350,130,30);
		bin.setFont(new Font("Cambria ",Font.BOLD+Font.ITALIC,15));
		bin.setForeground(new Color(100, 30, 22));
		bin.addActionListener(this);
		p.add(bin);
		
		bted=new JButton("Modification");
		bted.setBounds(100,400,130,30);
		bted.setFont(new Font("Cambria ",Font.BOLD+Font.ITALIC,15));
		bted.setForeground(new Color(100, 30, 22));
		bted.addActionListener(this);
		p.add(bted);
		
		ImageIcon img = new ImageIcon("livre.jpeg");
	
		labelim= new JLabel("Dog Gif",img, SwingConstants.CENTER);
	
		labelim.setBounds(0,530,900,200);
		p.add(labelim);
		
		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("identifiant");
		df.addColumn("titre ");
		df.addColumn("genre");
		df.addColumn("auteur");
		df.addColumn("date d'apparition");
jt.setModel(df);
		p.add(js);
	
		String qr="select * from livre"; 
		try{
			st=Connctdb.configDB().createStatement();
			rst=st.executeQuery(qr); 
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("id_liv"),rst.getString("nom_liv"),rst.getString("genre_liv")
						,rst.getString("auteur_liv"),rst.getString("date_par")});
			}
			
			
		}
		catch(SQLException ex){
			
		}
		
		
	}
	public void init(){
		jt=new JTable();
		js=new JScrollPane();
		js.setViewportView(jt);
		js.setBounds(320,200,550,300);

		
		
	}
	public void actionPerformed(ActionEvent e) {
		//rechercher
		if(e.getSource()==bsl){
	    	  String a;
				a=tfid.getText();
				String qr="select * from livre where id_liv='"+a+"'";
				try{
					st=Connctdb.configDB().createStatement();
					rst=st.executeQuery(qr);
					if(rst.next()){
						tftitr.setText(rst.getString("nom_liv"));
						gr.setSelectedItem(rst.getString("genre_liv"));
						tfaut.setText(rst.getString("auteur_liv"));
						datePicker.getJFormattedTextField().setText(rst.getString("date_par"));
						
					}
					else
						JOptionPane.showMessageDialog(this,"le livre est introuvable!",null,JOptionPane.ERROR_MESSAGE);
				}
				catch(SQLException ex){
				
				}
	    	  
	      }
		if(e.getSource()==bdel){
			String a;
			a=tfid.getText();
			String qr="delete from livre where id_liv='"+a+"'";
			try{
				st=Connctdb.configDB().createStatement();
				if(JOptionPane.showConfirmDialog(this,"voulez vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"suppression reussie!");
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Erreur,supression impossible!",null,JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==bin){
			String a,b,c,d,f;
			a=tfid.getText();
			b=tftitr.getText();
			c=(String)gr.getSelectedItem().toString();
			
			d=tfaut.getText();
			f = datePicker.getJFormattedTextField().getText();
			
			
			
			String qr="insert into livre(id_liv,nom_liv,genre_liv,auteur_liv,date_par)"
					+ "values('"+a+"','"+b+"','"+c+"','"+d+"','"+f+"')";
			try{
				st=Connctdb.configDB().createStatement();
				if(JOptionPane.showConfirmDialog(this,"voulez vous inserer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					 
					st.executeUpdate(qr);
					
					JOptionPane.showMessageDialog(this,"Insertion reussie!");
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Erreur,insertion impossible!",null,JOptionPane.ERROR_MESSAGE);
			}
				
			}
		if(e.getSource()==bted){
			String a,b,c,d,f;
			a=tfid.getText();b=tftitr.getText();c=gr.getSelectedItem().toString();d=tfaut.getText();f = datePicker.getJFormattedTextField().getText();
			String qr="update livre set nom_liv ='"+b+"',genre_liv = '"+c+"', auteur_liv = '"+d+"',date_par = '"+f+"' where id_liv='"+a+"'";
			try{
				st=Connctdb.configDB().createStatement();
				if(JOptionPane.showConfirmDialog(this,"voulez vous modifier?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"modification reussie!");
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Erreur,modification impossible!",null,JOptionPane.ERROR_MESSAGE);
			}
				
			}
		if(e.getSource()==btact){
			dispose();
			Livre lv;
			try {
				lv = new Livre();
				lv.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
			}
	
	
	public static void main(String[] args)throws IOException {
		
    Livre lv=new Livre();
    lv.setVisible(true);
	}
	}

