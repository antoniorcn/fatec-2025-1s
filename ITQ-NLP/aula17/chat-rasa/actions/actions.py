# This files contains your custom actions which can be used to run
# custom Python code.
#
# See this guide on how to implement these action:
# https://rasa.com/docs/rasa/custom-actions


# This is a simple example for a custom action which utters "Hello World!"

import os
from typing import Any, Text, Dict, List

from rasa_sdk import Action, Tracker
from rasa_sdk.executor import CollectingDispatcher


class ActionPedirPizza(Action):

    def name(self) -> Text:
        return "acao_pedir_pizza"

    def run(self, dispatcher: CollectingDispatcher,
            tracker: Tracker,
            domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:

        dispatcher.utter_message(text="Pedido de pizza realizado")

        return []


class ActionListarDiretorioRaiz(Action):

    def name(self) -> Text:
        return "acao_listar_raiz"

    def run(self, dispatcher: CollectingDispatcher,
            tracker: Tracker,
            domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
        diretorios = os.listdir("/")
        dispatcher.utter_message(text=f"Diretorios {diretorios}")

        return []
