# Bucket-based File Encryption Flow Diagram
## 1. Flow-Diagram
```mermaid
flowchart TB

    %% =======================
    %% Client Layer
    %% =======================
    subgraph Clients
        Agent[Call Handler Agent]
    end

    %% =======================
    %% Object Storage
    %% =======================
    subgraph Cloud_Storage["Cloud Object Storage"]
        AWS[S3 Bucket]
        GCP[GCS Bucket]
    end

    %% =======================
    %% Encryption Service
    %% =======================
    subgraph Encryption_Service["Encryption Service"]
        ES[Encrypt & Upload]
    end

    %% =======================
    %% Raw Data Cleanup
    %% =======================
    subgraph Cleanup["Raw Audio Cleanup"]
        AWSC[S3 Lambda Cleanup]
        GCPC[GCS Cloud Function Cleanup]
    end

    %% =======================
    %% Flow
    %% =======================
    Agent -->|Upload Raw Audio| AWS
    Agent -->|Upload Raw Audio| GCP

    AWS -->|S3 Event / EventBridge| ES
    GCP -->|GCS Notification / Pub-Sub| ES

    ES -->|Upload Encrypted Audio| AWS
    ES -->|Upload Encrypted Audio| GCP

    AWS -->|Post-Encryption Trigger| AWSC
    GCP -->|Post-Encryption Trigger| GCPC
