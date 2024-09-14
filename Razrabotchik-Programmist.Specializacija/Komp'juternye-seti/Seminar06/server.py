import socket
import threading

# Connection Data
host = 'localhost'
port = 55555

# Starting Server
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((host, port))
server.listen()

# Lists For Clients and Their Nicknames
clients = []
nicknames = []

# Sending Messages To All Connected Clients
def broadcast(message, exclude_client=None):
    for client in clients:
        if client != exclude_client:  # Do not send the message back to the sender
            client.send(message)

# Handling Messages From Clients
def handle(client):
    while True:
        try:
            # Receiving Messages
            message = client.recv(1024)
            broadcast(message, client)
        except:
            # Removing And Closing Clients
            index = clients.index(client)
            clients.remove(client)
            client.close()
            nickname = nicknames[index]
            broadcast(f'{nickname} left the chat.'.encode('utf-8'))
            nicknames.remove(nickname)
            print(f"{nickname} disconnected.")
            break

# Receiving / Listening Function
def receive():
    while True:
        if len(clients) >= 10:  # Set a maximum number of clients
            print("Maximum number of clients reached!")
            continue

        # Accept Connection
        client, address = server.accept()
        print(f"Connected with {str(address)}")

        # Request And Store Nickname
        client.send('NICK'.encode('utf-8'))
        nickname = client.recv(1024).decode('utf-8')

        if nickname.lower() == "admin":
            client.send("Reserved nickname. Choose a different one.".encode('utf-8'))
            client.close()
            continue

        nicknames.append(nickname)
        clients.append(client)

        # Print And Broadcast Nickname
        print(f"Nickname is {nickname}")
        broadcast(f"{nickname} joined the chat!".encode('utf-8'))
        client.send('Connected to server!'.encode('utf-8'))

        # Start Handling Thread For Client
        thread = threading.Thread(target=handle, args=(client,))
        thread.start()

print("Server is listening...")
receive()
