/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;
import paquetecinco.ArchivoEscrituraCons;
import paquetecinco.ArchivoLecturaCons;
import paquetecinco.Constructora;
import paquetecuatro.ArchivoEscrituraCiu;
import paquetecuatro.ArchivoLecturaCiu;
import paquetecuatro.Ciudad;
import paquetedos.ArchivoEscrituraPro;
import paquetedos.ArchivoLecturaPro;
import paquetedos.Propietario;
import paqueteseis.ArchivoEscribirCasa;
import paqueteseis.ArchivoEscrituraDepa;
import paqueteseis.ArchivoLecturaCasa;
import paqueteseis.ArchivoLecturaDepa;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetetres.ArchivoEscrituraUbi;
import paquetetres.ArchivoLecturaUbi;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int op;
        boolean var = true;
        while (var) {
            System.out.println("De las siguiente opciones seleccione la acción que"
                    + "desea realizar: \n"
                    + "1) para ingresar propietarios\n2) para ingresar ubicaciones\n"
                    + "3) para ingresar ciudades\n"
                    + "4) para ingresar constructoras\n"
                    + "5) para ingresar casas\n"
                    + "6) para ingresar departamentos");
            op = entrada.nextInt();
            if (op == 1) {
                System.out.println("¿Cuántos propietarios desea ingresar: ");
                int x = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < x; i++) {
                    propietarios();
                }
            } else {
                if (op == 2) {
                    System.out.println("¿Cuántas ubicaciones desea ingresar: ");
                int x = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < x; i++) {
                    ubicacion();
                }
                } else {
                    if (op == 3) {
                        System.out.println("¿Cuántas ciudades desea ingresar: ");
                int x = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < x; i++) {
                        ciudad();
                }
                    } else {
                        if (op == 4) {
                            System.out.println("¿Cuántas constructoras "
                                    + "desea ingresar: ");
                int x = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < x; i++) {
                            constructora();
                }
                        } else {
                            if (op == 5) {
                                System.out.println("¿Cuántas casas desea ingresar: ");
                int x = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < x; i++) {
                                casa();
                }
                            } else {
                                if (op == 6) {
                                    System.out.println("¿Cuántos departamentos"
                                            + " desea ingresar: ");
                int x = entrada.nextInt();
                entrada.nextLine();
                for (int i = 0; i < x; i++) {
                                    departamento();
                }
                                } else {
                                    System.out.println("Error valor ingresado"
                                            + "no existe");
                                }
                            }
                        }
                    }
                }
            }
            entrada.nextLine();
            System.out.println("Ingrese 0 para ya no agregar valores: ");
            int confirmacion = entrada.nextInt();
            if (confirmacion == 0) {
                var = false;
            }
        }
    }

    public static void constructora() {
        Scanner entrada = new Scanner(System.in);
        String arch = "Constructora.data";
        String nConstructora;
        int ident;
        System.out.println("Ingrese el nombre de la constructora: ");
        nConstructora = entrada.nextLine();
        System.out.println("Ingrese la identificación de la empresa: ");
        ident = entrada.nextInt();

        Constructora constructora = new Constructora(nConstructora, ident);

        ArchivoEscrituraCons archivo = new ArchivoEscrituraCons(arch);
        archivo.establecerRegistroConstructora(constructora);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaCons lectura = new ArchivoLecturaCons(arch);
        lectura.establecerConstrutora();
        System.out.println(lectura);
    }

    public static void ciudad() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Ciudad.data";
        String nCiudad;
        String provincia;
        System.out.println("Ingrese nombre de la ciudad: ");
        nCiudad = entrada.nextLine();
        System.out.println("Ingrese el nombre de la provincia a la que pertenece:"
                + "\n");
        provincia = entrada.nextLine();

        Ciudad ciudad = new Ciudad(nCiudad, provincia);

        ArchivoEscrituraCiu archivo = new ArchivoEscrituraCiu(nArchivo);
        archivo.establecerRegistroCiudad(ciudad);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaCiu lectura = new ArchivoLecturaCiu(nArchivo);
        lectura.establecerCiudad();
        System.out.println(lectura);

    }

    public static void ubicacion() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Ubicacion.data";
        int numeroC;
        String nombreBarrio;
        String referencia;
        System.out.println("Ingrese el número de la casa casa: ");
        numeroC = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese nombre del barrio en el que está situada la "
                + "casa: ");
        nombreBarrio = entrada.nextLine();
        System.out.println("Referencia");
        referencia = entrada.nextLine();

        Ubicacion ubicacion = new Ubicacion(numeroC, nombreBarrio, referencia);

        ArchivoEscrituraUbi archivo = new ArchivoEscrituraUbi(nArchivo);
        archivo.establecerRegistro(ubicacion);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaUbi lectura = new ArchivoLecturaUbi(nArchivo);
        lectura.establecerUbicaciones();
        System.out.println(lectura);
    }

    public static void propietarios() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Propietarios.data";
        String nombre;
        String apellidos;
        String identificacion;
        System.out.println("Ingrese el nombre del propietario: ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese el apellido del propietario: ");
        apellidos = entrada.nextLine();
        System.out.println("Ingrese el numero de cédula o identificacion del "
                + "propietario: ");
        identificacion = entrada.nextLine();

        Propietario propietario = new Propietario(nombre, apellidos, identificacion);

        ArchivoEscrituraPro archivo = new ArchivoEscrituraPro(nArchivo);
        archivo.establecerRegistro(propietario);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaPro lectura = new ArchivoLecturaPro(nArchivo);
        lectura.establecerPropietarios();
        System.out.println(lectura);
    }

    public static void casa() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Casa.data";
        String propiet;
        double pMetroCuadrado;
        double nMetroCuadrado;
        int ubi;
        String nCiudad;
        int nCuartos;
        int identi;
        System.out.println("Ingrese la identifacion del propietario de la casa: ");
        propiet = entrada.nextLine();

        ArchivoLecturaPro lecturaPro = new ArchivoLecturaPro("Propietarios.data");
        lecturaPro.establecerPropietarios();
        lecturaPro.establecerPropietarioObjeto(propiet);
        Propietario propietario = lecturaPro.obtenerPropietariosObjeto();

        if (propietario != null) {
            System.out.println("Ingrese el precio por metro cuadrado: ");
            pMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese el cuántos metros cuadrados contiene: ");
            nMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese el número de casa: ");
            ubi = entrada.nextInt();
            ArchivoLecturaUbi lecturaUbi = new ArchivoLecturaUbi("Ubicacion.data");
            lecturaUbi.establecerUbicaciones();
            lecturaUbi.establecerUbicacionObjeto(ubi);
            Ubicacion ubicacion = lecturaUbi.obtenerUbicacionObjeto();
            if (ubicacion != null) {
                entrada.nextLine();
                System.out.println("Ingrese nombre de la ciudad: ");
                nCiudad = entrada.nextLine();
                System.out.println("Ingrese el número de cuartos de la casa: ");
                nCuartos = entrada.nextInt();
                ArchivoLecturaCiu lecturaCiu = new ArchivoLecturaCiu("Ciudad.data");
                lecturaCiu.establecerCiudad();
                lecturaCiu.establecerCiudadObjeto(nCiudad);
                Ciudad ciudad = lecturaCiu.obtenerCiudadObjeto();
                if (ciudad != null) {
                    System.out.println("Ingrese la número de identificación "
                            + "de la empresa de constructora: ");
                    identi = entrada.nextInt();
                    ArchivoLecturaCons lecturaCons = new ArchivoLecturaCons("Constructora.data");
                    lecturaCons.establecerConstrutora();
                    lecturaCons.establecerConstructoraObjeto(identi);
                    Constructora constructora = lecturaCons.obtenerConstructoraObjeto();
                    if (constructora != null) {
                        Casa casa = new Casa(propietario, pMetroCuadrado,
                                nMetroCuadrado, ubicacion, ciudad, nCuartos,
                                constructora);
                        casa.calcularCostoFinal();
                        System.out.println(casa);
                        ArchivoEscribirCasa archivo
                                = new ArchivoEscribirCasa(nArchivo);
                        archivo.establecerRegistro(casa);
                        archivo.establecerSalida();
                        archivo.cerrarArchivo();

                        ArchivoLecturaCasa lectura =
                                new ArchivoLecturaCasa(nArchivo);
                        lectura.establecerCasas();
                       
                    } else {
                        System.out.println("Debe ingresar los"
                                + " valores en constructora");
                    }
                } else {
                    System.out.println("Debe ingresar los valores en ciudad");
                }
            } else {
                System.out.println("Debe ingresar los valores en ubicacion");
            }
        } else {
            System.out.println("Debe ingresar los valores en propietario");
        }
    }

    public static void departamento() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Departamento.data";
        String prop;
        double pMetroCuadrado;
        double nMetroCuadrado;
        double vAliCoutaMensual;
        double precio;
        int ubi;
        String nCiudad;
        String nombreEdificio;
        String ubicacionDE;
        int identi;
        System.out.println("Ingrese la identifacion del propietario");
        prop = entrada.nextLine();
        ArchivoLecturaPro lecturaPro = new ArchivoLecturaPro("Propietarios.data");
        lecturaPro.establecerPropietarios();
        lecturaPro.establecerPropietarioObjeto(prop);
        Propietario propietario = lecturaPro.obtenerPropietariosObjeto();
        if (propietario != null) {
            System.out.println("Ingrese el precio por metro cuadrado: ");
            pMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese la cantidad de metros cuadrados:");
            nMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese el valor de la alicuota mensual: ");
            vAliCoutaMensual = entrada.nextDouble();
            System.out.println("Ingrese el precio del bien inmueble: ");
            precio = entrada.nextDouble();
            System.out.println("Ingrese el número de casa en la que se encuentra:"
                    + " ");
            ubi = entrada.nextInt();
            ArchivoLecturaUbi lecturaUbi = new ArchivoLecturaUbi("Ubicacion.data");
            lecturaUbi.establecerUbicaciones();
            lecturaUbi.establecerUbicacionObjeto(ubi);
            Ubicacion ubicacion = lecturaUbi.obtenerUbicacionObjeto();
            if (ubicacion != null) {
                entrada.nextLine();
                System.out.println("Ingrese nombre de la ciudad en la que está"
                        + " situada: ");
                nCiudad = entrada.nextLine();
                ArchivoLecturaCiu lecturaC = new ArchivoLecturaCiu("Ciudad.data");
                lecturaC.establecerCiudad();
                lecturaC.establecerCiudadObjeto(nCiudad);
                Ciudad ciudad = lecturaC.obtenerCiudadObjeto();
                if (ciudad != null) {
                    System.out.println("Ingrese el nombre del edificio en el "
                            + "que se encuentra: ");
                    nombreEdificio = entrada.nextLine();
                    System.out.println("Ingrese la ubicacion del edificio: ");
                    ubicacionDE = entrada.nextLine();
                    System.out.println("Ingrese el número de identificacion"
                            + " de la empresa de constructora: ");
                    identi = entrada.nextInt();
                    ArchivoLecturaCons lecturaCons = 
                            new ArchivoLecturaCons("Constructora.data");
                    lecturaCons.establecerConstrutora();
                    lecturaCons.establecerConstructoraObjeto(identi);
                    Constructora constructora = lecturaCons.obtenerConstructoraObjeto();
                    if (constructora != null) {
                        Departamento departamento = new Departamento(propietario,
                                pMetroCuadrado, nMetroCuadrado, vAliCoutaMensual,
                                precio, ubicacion, ciudad, nombreEdificio, ubicacionDE,
                                constructora);
                        departamento.calcularCostoFinal();
                        System.out.println(departamento);

                        ArchivoEscrituraDepa archivo = new ArchivoEscrituraDepa(
                                nArchivo);
                        archivo.establecerRegistro(departamento);
                        archivo.establecerSalida();
                        archivo.cerrarArchivo();
                        ArchivoLecturaDepa lectura = new ArchivoLecturaDepa(nArchivo);
                        lectura.establecerDepartamento();
                       
                    } else {
                        System.out.println("Debe ingresar valores en constructora: ");
                    }
                } else {
                    System.out.println("Debe ingresar valores en ciudad: ");
                }
            } else {
                System.out.println("Debe ingresar valores en ubicacion: ");
            }
        } else {
            System.out.println("Debe ingresar valores en propietarios: ");
        }
    }

}
