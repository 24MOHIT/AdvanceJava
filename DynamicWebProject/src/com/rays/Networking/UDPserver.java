package com.rays.Networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPserver {

	public static void main(String[] args) throws Exception {

		String[] qoutes = { "Bura Mat Dekho", "Bura Mat Kaho", "Bura Mat Suno" };

		DatagramSocket socket = new DatagramSocket(4445);

		byte[] buf = new byte[256];

		DatagramPacket packet = new DatagramPacket(buf, buf.length);

		boolean flag = true;

		while (flag) {
			socket.receive(packet);

			InetAddress address = packet.getAddress();

			int port = packet.getPort();

			int ind = (int) (Math.random() * 2);

			byte[] quote = qoutes[ind].getBytes();

			DatagramPacket qoutepk = new DatagramPacket(quote, quote.length, address, port);

			socket.send(qoutepk);

		}
		socket.close();
	}
}
