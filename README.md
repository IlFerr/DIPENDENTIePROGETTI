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

# Requisiti
1. Must
    - Aggiungere, modificare e cancellare un dipendente
    - Aggiungere, modificare e cancellare un progetto.
    - Visualizzare tutti i dipendenti
    - Visualizzare tutti i progetti in corso, quelli scaduti e quelli completati
    - Aggiungere o rimuovere un dipendente al gruppo di un team leader
    - Assegnare un progetto a un team leader
    - Visualizzare tutti i dipendenti assegnati a un progetto
    - Visualizzare tutti i progetti a cui un dipendente è stato assegnato
    - Creazione di un'interfaccia grafica

2. Should
    - Requisito di ordinamento per data di scadenza dei progetti
    - Ordinamento per ordine alfabetico e per  tipo dei dipendenti

3. May
    - Esportazione/Importazione Dati → Salvataggio e caricamento dati (CSV, Excel, PDF).
    - Storico Modifiche → Tracciamento delle modifiche su progetti e dipendenti.
    - Suggerimenti Automatici → Proposta automatica di dipendenti per i progetti.
    - Dashboard Statistica → Grafici e statistiche su progetti e team.
    - Ricerca Avanzata → Filtri per trovare facilmente progetti o persone.
    - Notifiche e Promemoria → Avvisi per scadenze, cambi e assegnazioni.
    - Accesso Multiutente/Ruoli → Login differenziato (admin, PM, team leader…).
    - Gestione Documenti Avanzata → Upload/download con categorie e tag.
    - Integrazione Esterna → Collegamento con strumenti esterni (es. Trello, Jira).





# Tabelle Requisiti Must

| Nome           | AggiungiDipendente                                      |
| -------------- | ------------------------------------------------------- |
| ID             | CU1                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Devono essere presenti nome, ID e tipo di un dipendente |
| Postcondizioni | Il dipendente viene aggiunto                            |


| Nome           | AggiungiProgetto                                        |
|--------------- | ------------------------------------------------------- |
| ID             | CU2                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Devono essere presenti ID, nome,                        |
|                |  data di scadenza, budget e documenti collegati         |
| Postcondizioni | Il progetto viene aggiunto                              |



| Nome           | RimuoviDipendente                                       |
|--------------- | ------------------------------------------------------- |
| ID             | CU3                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere selezionato un dipendente                   |
| Postcondizioni | Il dipendente viene rimosso                             |



| Nome           | RimuoviProgetto                                         |
|--------------- | ------------------------------------------------------- |
| ID             | CU4                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere selezionato un progetto                     |
| Postcondizioni | Il progetto viene rimosso                               |



| Nome           | ModificaDipendente                                      |
|--------------- | ------------------------------------------------------- |
| ID             | CU5                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere selezionato un dipendente                   |
|                | Devono essere reinseriti i dati di un dipendente        |
|                | Devono essere confermare le modifiche                   |
| Postcondizioni | Il dipendente viene modificato                          |



| Nome           | ModificaProgetto                                        |
|--------------- | ------------------------------------------------------- |
| ID             | CU6                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere selezionato un progetto                     |
|                | Devono essere reinseriti i dati di un progetto          |
|                | Devono essere confermare le modifiche                   |
| Postcondizioni | Il progetto viene modificato                            |



| Nome           | VisualizzaDipendenti                                    |
|--------------- | ------------------------------------------------------- |
| ID             | CU7                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Devono essere selezionati i dipendenti                  |
| Postcondizioni | I dipendenti vengono visualizzati                       |



| Nome           | VisualizzaProgettiScaduti                               |
|--------------- | ------------------------------------------------------- |
| ID             | CU8                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere deciso il metodo di visualizzazione         |
|                | Viene effettuato un controllo                           |
| Postcondizioni | Il progetto viene aggiunto                              |



| Nome           | VisualizzaProgettiInCorso                               |
|--------------- | ------------------------------------------------------- |
| ID             | CU9                                                     |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere deciso il metodo di visualizzazione         |
|                | Viene effettuato un controllo                           |
| Postcondizioni | I progetti in corso vengono visualizzati                |



| Nome           | VisualizzaProgettiCompletati                            |
|--------------- | ------------------------------------------------------- |
| ID             | CU10                                                    |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere deciso il metodo di visualizzazione         |
|                | Viene effettuato un controllo                           |
| Postcondizioni | I progetti completati vengono visualizzati              |



| Nome           | AggiungiDipendenteGruppo                                |
|--------------- | ------------------------------------------------------- |
| ID             | CU11                                                    |
| Attori         | Project Manager                                         |
| Precondizioni  | Devono essere presenti ID, nome, data di scadenza,      |
|                | budget e documenti collegati                            |
| Postcondizioni | Il dipendente viene aggiunto al gruppo del team leader  |



| Nome           | RimuoviDipendenteGruppo                                 |
|--------------- | ------------------------------------------------------- |
| ID             | CU12                                                    |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere selezionato un dipendente                   |
| Postcondizioni | Il dipendente viene rimosso dal gruppo del team leader  |


 
| Nome           | AssegnaProgetto                                         |
|--------------- | ------------------------------------------------------- |
| ID             | CU13                                                    |
| Attori         | Project Manager                                         |
| Precondizioni  | Devono essere selezionato un team leader                |
| Postcondizioni | Il progetto viene assegnato al team leader e            |
|                | ai sui dipendeni                                        |



| Nome           | VisualizzaDipendentiProgetto                            |
|--------------- | ------------------------------------------------------- |
| ID             | CU14                                                    |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere selezionato un progetto                     |
| Postcondizioni | Vengono visualizzati tutti i dipendenti                 |
|                | del progetto selezionato                                |



| Nome           | VisualizzaProgettiDipendente                            |
|--------------- | ------------------------------------------------------- |
| ID             | CU15                                                    |
| Attori         | Project Manager                                         |
| Precondizioni  | Deve essere selezionato un dipendente                   |
| Postcondizioni | Vengono visualizzati tutti i progetti del               |
|                | dipendenti selezionato                                  |
