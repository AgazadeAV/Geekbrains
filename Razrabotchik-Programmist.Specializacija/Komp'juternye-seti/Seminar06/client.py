import socket
import threading
import time

# Choosing Nickname
nickname = input("Choose your nickname: ")

# Connecting To Server
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
try:
    client.connect(('localhost', 55555))
except ConnectionRefusedError:
    print("Failed to connect to the server. Please check the server address.")
    exit()

# Listening to Server and Sending Nickname
def receive():
    while True:
        try:
            # Receive Message From Server
            message = client.recv(1024).decode('utf-8')
            if message == 'NICK':
                client.send(nickname.encode('utf-8'))
            else:
                print(message)
        except Exception as e:
            print(f"An error occurred: {e}")
            client.close()
            break

def write():
    while True:
        message = input('')
        if message.lower() == '/exit':
            client.send(f'{nickname} has left the chat.'.encode('utf-8'))
            client.close()
            print("You have left the chat.")
            break
        else:
            # Adding a timestamp to the message
            timestamp = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())
            formatted_message = f'[{timestamp}] {nickname}: {message}'
            client.send(formatted_message.encode('utf-8'))

# Starting Threads For Listening And Writing
receive_thread = threading.Thread(target=receive)
receive_thread.start()

write_thread = threading.Thread(target=write)
write_thread.start()
