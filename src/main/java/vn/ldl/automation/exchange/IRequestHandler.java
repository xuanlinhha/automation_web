package vn.ldl.automation.exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class IRequestHandler {
	private static final int PORT = 2190;

	public static IResponse handleIRequest(String address, IRequest request) {
		IResponse response = new IResponse();

		try (Socket socket = new Socket(address, PORT);
				PrintWriter out = new PrintWriter(socket.getOutputStream(),
						true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()))) {

			String requestData = request.toIRequestString();
			out.print(requestData);
			out.flush();

			String responseData = in.readLine();
			response.setStatus(responseData);
			responseData = in.readLine();
			response.setData(responseData);
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + address);
			response.setStatus(IResponse.FAIL);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to "
					+ address);
			response.setStatus(IResponse.FAIL);
		}
		return response;
	}
}
