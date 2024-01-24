import Card

class Player:
    """Player class"""
    def __init__(self, name: str) -> None:
        self.wins: int = 0
        self.card: Card = None
        self.name: str = name