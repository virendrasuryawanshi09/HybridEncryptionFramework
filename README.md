
# Hybrid Encryption Framework for Secure Data Transmission

## Overview

The **Hybrid Encryption Framework** is designed to provide secure data transmission by combining both **symmetric** and **asymmetric encryption** techniques. The framework employs the power of **AES (Advanced Encryption Standard)** for data encryption and **RSA (Rivest-Shamir-Adleman)** for securely exchanging the AES encryption key.

## Features

- **Symmetric encryption** using AES to encrypt large data efficiently.
- **Asymmetric encryption** using RSA to encrypt the AES key.
- **Hybrid encryption mechanism** to ensure both performance and security.
- Secure **data transmission** with encryption and decryption mechanisms.
- **Key management** for secure generation, storage, and usage of encryption keys.

## Technologies Used

- **Java**: The core programming language.
- **AES**: For symmetric encryption.
- **RSA**: For asymmetric encryption.
- **Git**: For version control.
- **IntelliJ IDEA**: IDE used for development.
- **Maven**: For dependency management.

## Project Structure
<pre>
HybridEncryptionFramework/
├── src/
│   ├── Encryption/
│   │   ├── <strong>SymmetricEncryption.java</strong>    # Handles AES encryption and decryption
│   │   ├── <strong>AsymmetricEncryption.java</strong>   # Manages RSA encryption and decryption
│   │   ├── <strong>HybridEncryption.java</strong>       # Integrates AES and RSA for hybrid encryption
│   │   ├── <strong>KeyManager.java</strong>             # Generates and manages keys (AES & RSA)
│   ├── main/
│       ├── <strong>Main.java</strong>                   # Entry point to run the encryption framework
├── <strong>.gitignore</strong>                          # Git ignore file
├── <strong>pom.xml</strong>                             # Maven build configuration file
├── <strong>README.md</strong>                           # Documentation for the project
</pre>

<h3>Description of Key Components</h3>
<ul>
  <li><strong>Encryption/</strong>
    <ul>
      <li><strong>SymmetricEncryption.java</strong>: Implements AES for fast and secure data encryption.</li>
      <li><strong>AsymmetricEncryption.java</strong>: Implements RSA for secure AES key exchange.</li>
      <li><strong>HybridEncryption.java</strong>: Combines AES and RSA for hybrid encryption.</li>
      <li><strong>KeyManager.java</strong>: Generates and manages cryptographic keys.</li>
    </ul>
  </li>
  <li><strong>main/</strong>
    <ul>
      <li><strong>Main.java</strong>: Provides the user interface and demonstrates the encryption and decryption processes.</li>
    </ul>
  </li>
  <li><strong>pom.xml</strong>: Maven configuration file to manage dependencies and build the project.</li>
</ul>

## Workflow of Hybrid Encryption

1. **Sender**:
   - The sender generates an AES key using symmetric encryption.
   - The data is encrypted with the AES key.
   - The AES key is then encrypted using the RSA public key.
   - Both the encrypted data and the encrypted AES key are transmitted to the receiver.

2. **Receiver**:
   - The receiver uses the RSA private key to decrypt the AES key.
   - The AES key is then used to decrypt the encrypted data, recovering the original message.

## How It Works

### 1. Key Generation

- **AES Key Generation**: An AES key is randomly generated to encrypt the data. This key is symmetric, meaning the same key is used for both encryption and decryption.
  
- **RSA Key Pair Generation**: A pair of RSA keys (public and private) is generated. The public key is used to encrypt the AES key, while the private key is used to decrypt the AES key.

### 2. Encryption Process

- The data is encrypted using the AES algorithm.
- The AES key is encrypted using the RSA public key.
  
### 3. Decryption Process

- The RSA private key is used to decrypt the AES key.
- The decrypted AES key is then used to decrypt the data.

## Getting Started

### Clone the Repository

To clone the repository, run the following command:

```bash
git clone https://github.com/virendrasuryawanshi09/HybridEncryptionFramework.git

