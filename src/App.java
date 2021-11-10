import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Integer token = (int) (Math.random() * ( 999999 - 100000 ));
		String usuario = "administrador";
		String contrasena = "administrador.1234";
		String usuarioIn = "", contrasenaIn= "", tokenIn = "", reintentar = "S";
		Integer intentosRestantes = 3;
		Scanner console = new Scanner(System.in);
		Boolean fallo = Boolean.FALSE;
		
		
		System.out.println("Bievenido a Online Banking, por favor ingrese las credenciales solicitadas: \n");


		System.out.print("Clave token generada automáticamente: ");
		System.out.print(token.toString()+"\n");


		do{
			intentosRestantes--;

			do{
				System.out.println("Usuario: ");
				usuarioIn = console.nextLine().toLowerCase();
			}while (usuarioIn == "");
			
			do {
				System.out.println("Contraseña: ");
				contrasenaIn = console.nextLine();
			}while (contrasenaIn == "");

			do {
				System.out.println("Clave Token: ");
				tokenIn = console.nextLine().toLowerCase();
			}while (tokenIn == "");
			
			Integer tokenInParseado = Integer.parseInt(tokenIn);
			
			if(usuarioIn.equals(usuario)) {
				if(contrasenaIn.equals(contrasena)) {
					if(tokenInParseado.equals(token)) {
						System.out.println("Credenciales correctas, bienvenido a su Online Banking.");
						break;
					}else {
						fallo = Boolean.TRUE;
					}
				}else {
					fallo = Boolean.TRUE;
				}
			}else {
				fallo = Boolean.TRUE;
			}
			
			if(fallo) {
				if(intentosRestantes > 0) {
					System.out.println("Error de credenciales, desea intentarlo nuevamente? S/N: ");
					reintentar = console.nextLine().toUpperCase();
					if(reintentar.equals("N")) {
						System.out.println("Gracias por utilizar Online Banking.");
						
					}
				}else {
					System.out.println("Error de credenciales. Usuario bloqueado, por favor dirijase a la sucursal mas cercana.");
				}
			}
		}while (intentosRestantes > 0 && reintentar.equals("S"));
		

		
		
		console.close();

		
	}

}
