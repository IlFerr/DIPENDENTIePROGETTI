# Dipendenti e Progetti
Scrivi un programma che gestisca un’azienda con dipendenti e progetti. Ogni dipendente ha un nome, un’ ID e un insieme di progetti assegnati. Ogni progetto ha un nome e una data di scadenza,il team manager, il budget, i documenti collegati (Project charter, preventivi, nulla osta…) e stato di avanzamento. I dipendenti hanno mansioni diverse team manager (caratterizzato dal numero di progetti firmati fino ad ora), un analista, un progettista, un programmatore (linguaggi di programmazione in cui è specializzato), un tester e un garante della qualità (certificazioni abilitato ad essere garante).
Oltre alla gestione degli inserimenti, modifiche, cancellazioni, si vuole poter gestire uno storico e poter fare le seguenti interrogazioni:
1. le persone collegate ad un progetto
2. i progetti collegati con un dipendente
3. i progetti attivi in una certa data
4. i progetti terminati

# Analisi del contesto
Il progetto richiede un'applicazione in grado di gestire i dati dei clienti e dei progetti a cui lavorano concentrandosi particolarmente sull’interazione tra di essi, inoltre deve possedere uno storico che permette di interrogare informazioni storiche sui progetti e sui dipendenti. Questo programma è pensato per tutte le figure che sono coinvolte nella gestione dei progetti e di risorse aziendali come project manager o dirigenti.

# Ipotesi
1. Identificazione dei Dipendenti e dei Progetti
    a. Ogni dipendente avrà un ID univoco per l’identificazione.
    b. I dipendenti saranno classificati in diversi ruoli: Team Manager, Analista, Progettista, Programmatore e Garante della Qualità;
    c. Ogni progetto avrà un nome, una data di scadenza, un team manager assegnato, un budget, documenti associati e uno stato di avanzamento;

2. Gestione delle Relazioni Dipendenti-Progetti
    a. Un dipendente può essere assegnato a più progetti contemporaneamente.
    b. Ogni progetto avrà un insieme di dipendenti con ruoli specifici.
    c. Il team manager avrà il compito di supervisionare il progetto e sarà caratterizzato dal numero di progetti gestiti in passato.

3. Funzionalità Aggiuntive (Opzionali)
    a. Una Ui per facilitare l’interazione con il sistema.
    b. Notifiche automatiche per aggiornamento rilevanti sui progetti.
    c. Integrazione con altri software aziendali, come ad esempio dei sistemi di gestione documentale.

# Analisi dei dati
1. Dipendente
    - ID (Stringa) → identificativo univoco del dipendente.
    - Nome (Stringa) → Nome completo del dipendente.
    - Ruolo:
        - Team Manager
        - Analista
        - Progettista
        - Programmatore
        - Tester
        - Garante della qualità

2. Progetto
    - ID (Stringa) → identificativo univoco del progetto.
    - Nome (Stringa) → nome del progetto.
    - Data di scadenza (Local Date) → data limite per la progettazione del progetto.
    - Budget (Float) → risorse finanziarie a disposizione del progetto.
    - Documenti collegati (Array List di Stringhe) → File associati al progetto (Opzionale).
    - Stato di avanzamento:
        - Non avviato
        - In corso
        - Completato
        - Annullato
        - Requisiti

# Must
- Gestione dipendenti e progetti
    - Il programma deve permettere di aggiungere, modificare e cancellare dipendenti e progetti.
    - Ogni dipendente deve essere identificato da un ID univoco.
    - Ogni progetto deve avere un nome, una data di scadenza, un team manager, un budget, documenti collegati e uno stato di avanzamento.

- Gestione dei ruoli
    - Ogni dipendente deve essere associato a un progetto con un ruolo specifico.
    - Il sistema deve essere in grado di tenere traccia del numero di progetti firmati dal team manager e delle certificazioni per il garante della qualità.

- Storico delle modifiche
    - Il programma deve tenere traccia delle modifiche sui dati dei dipendenti e dei progetti in modo da poter consultare lo storico delle modifiche.

- Interrogazioni di base
    - Il programma deve supportare interrogazioni per recuperare:
    - Le persone collegate a un progetto.
    - I progetti a cui un dipendente è collegato.
    - I progetti attivi in una certa data.
    - I progetti terminati.

# Should
- Interfaccia utente
    - Sebbene non strettamente necessario, una UI (ad esempio, basata su web o desktop) potrebbe rendere il sistema più accessibile e intuitivo per gli utenti non tecnici.

# May
- Filtraggio avanzato
    - Il programma potrebbe offrire funzionalità avanzate di filtraggio per le interrogazioni, come la possibilità di ordinare i progetti per stato di avanzamento o budget.
    - Potrebbe anche essere utile consentire di fare ricerche basate su più criteri contemporaneamente (es. tutti i progetti in scadenza entro una certa data e con un certo stato di avanzamento).
