from random import shuffle
from typing import List
from Card import Card


class Deck:
    """Deck class"""
    def __init__(self) -> None:
        self.cards: List[Card] = []
        for i in range(2, 15):
            for j in range(4):
                self.cards.append(Card(i, j))
        for i in range(7):
            shuffle(self.cards)
        
    def rm_card(self) -> Card:
        if len(self.cards) == 0:
            return
        
        return self.cards.pop()
    
